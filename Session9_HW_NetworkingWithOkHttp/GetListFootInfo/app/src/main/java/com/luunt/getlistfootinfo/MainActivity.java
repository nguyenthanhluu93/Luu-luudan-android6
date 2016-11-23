package com.luunt.getlistfootinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.luunt.getlistfootinfo.adapters.FoodAdapter;
import com.luunt.getlistfootinfo.models.FoodInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private ListView lvFood;
    private ArrayAdapter<FoodInfo> foodInfoArrayAdapter;
    private ArrayList<FoodInfo> foodInfosList;

    private String url = "https://a-server.herokuapp.com/api/food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        initData();
        cofigUI();
        sendGET();
    }

    private void cofigUI() {
        foodInfoArrayAdapter = new FoodAdapter(this, R.layout.item_list_food, foodInfosList);
        lvFood.setAdapter(foodInfoArrayAdapter);
    }

    private void initData() {
        foodInfosList = new ArrayList<>();
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
                FoodInfo[] foodInfos = gson.fromJson(body, FoodInfo[].class);
                foodInfosList.clear();
                foodInfosList.addAll(Arrays.asList(foodInfos));
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        foodInfoArrayAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void getReferences() {
        lvFood = (ListView) findViewById(R.id.lv_food);
    }
}
