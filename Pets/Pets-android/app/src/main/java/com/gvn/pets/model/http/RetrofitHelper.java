package com.gvn.pets.model.http;

import com.gvn.pets.BuildConfig;
import com.gvn.pets.app.Constants;
import com.gvn.pets.model.http.service.RequestService;
import com.gvn.pets.utils.LogUtil;
import com.gvn.pets.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by namIT on 11/22/2016.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient = null;
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private void init() {
        initOkHttp();
    }

    public RetrofitHelper() {
        init();
    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtils.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtils.isNetworkConnected()) {
                    int maxAge = 0;
                    // When there is a network, it is not cached
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // No network, set the timeout to 4 weeks
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .build();
//                return chain.proceed(request);
//            }
//        };
//        builder.addInterceptor(apikey);
        //Set the cache
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //Set the timeout
        builder.connectTimeout(BuildConfig.TIMEOUT_CONNECT, TimeUnit.SECONDS);
        builder.readTimeout(BuildConfig.TIMEOUT_READ, TimeUnit.SECONDS);
        builder.writeTimeout(BuildConfig.TIMEOUT_WRITE, TimeUnit.SECONDS);
        //Error reconnection
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            if (null == request.body()) {
                LogUtil.d("request", "request=" + request.url());
            } else {
                LogUtil.d("request", "request=" + request.body().toString());
            }
            Response response = chain.proceed(request);
            ResponseBody responseBody = response.body();
            long contentLength = responseBody.contentLength();
            long t2 = System.nanoTime();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            if (contentLength != 0) {
                LogUtil.d("received", "SECONDS: " + TimeUnit.SECONDS.convert((t2 - t1), TimeUnit.NANOSECONDS) + "\nreceived=" + buffer.clone().readString(charset));
            } else {
                LogUtil.d("received", response.message());
            }
            LogUtil.d("END HTTP", "(" + buffer.size() + "-byte body)");
            final String responseString = new String(response.body().bytes());
            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), responseString))
                    .build();
        }
    }

    public RequestService restartRequestServer() {
        Retrofit myRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return myRetrofit.create(RequestService.class);
    }
}
