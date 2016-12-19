package com.example.chihirohaku.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.chihirohaku.lab5.databases.DbContext;
import com.example.chihirohaku.lab5.models.Home;
import com.example.chihirohaku.lab5.models.ResponData;
import com.example.chihirohaku.lab5.models.ResquestBody;
import com.example.chihirohaku.lab5.services.RegisterService;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbContext.init(this);

        sendPOST();
    }

    private void sendPOST() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://api.30shine.com/category/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterService registerService = retrofit.create(RegisterService.class);

        ResquestBody resquestBody = new ResquestBody();

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                (new Gson()).toJson(resquestBody));

        Call<ResponData> register = registerService.register(requestBody);
        register.enqueue(new Callback<ResponData>() {
            @Override
            public void onResponse(Call<ResponData> call, Response<ResponData> response) {
                Log.d(TAG, String.format("onResponse: %s", response.body().toString()));
                ResponData responData = response.body();
                if (DbContext.getInstance().allData().size() != 0) {
                    DbContext.getInstance().deleteAll();
                }
                    for (Home home : responData.getHomeArrayList()) {
                        Log.d(TAG, String.format("home: %s", home.toString()));
                        DbContext.getInstance().insert(home);
                    }

            }

            @Override
            public void onFailure(Call<ResponData> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
                for (Home home : DbContext.getInstance().allData()) {
                    Log.d(TAG, home.toString());
                }
            }
        });
    }
}
