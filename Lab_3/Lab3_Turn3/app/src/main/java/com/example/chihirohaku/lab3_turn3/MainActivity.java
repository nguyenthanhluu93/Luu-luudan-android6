package com.example.chihirohaku.lab3_turn3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private String url = "http://a-server.herokuapp.com/api/hairstyle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendGET();
    }

    private void sendGET() {
        OkHttpClient client = new OkHttpClient();
        Request req
    }
}
