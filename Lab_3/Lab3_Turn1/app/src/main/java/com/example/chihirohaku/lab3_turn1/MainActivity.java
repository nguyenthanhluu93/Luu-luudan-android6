package com.example.chihirohaku.lab3_turn1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private String url = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendGET();
    }

    private void sendGET() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure: %s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("onResponse: %s", body));
                Gson gson = new Gson();
                Posts[] postses = gson.fromJson(body, Posts[].class);
                for (Posts posts : postses) {
                    Log.d(TAG, String.format("%s, %s, %s, %s", posts.getUserId(), posts.getId(), posts.getTitle(), posts.getBody()));                }
            }
        });
    }
}
