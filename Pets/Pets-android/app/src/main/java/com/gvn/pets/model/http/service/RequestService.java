package com.gvn.pets.model.http.service;

import com.gvn.pets.model.bean.TestBean;
import com.gvn.pets.model.http.api.TestRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by namIT on 11/24/2016.
 */

public interface RequestService {

    @POST("/list_conversation")
    Call<TestBean> getListConversation(@Body TestRequest  request);

    @GET("3/movie/{categories}")
    Call<ResponseBody> getMoviesInfo(@Path("categories") String categories, @Query("page") int page, @Query("api_key") String apiKey);
}
