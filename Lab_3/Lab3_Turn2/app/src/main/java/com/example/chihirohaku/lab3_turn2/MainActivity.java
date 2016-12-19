package com.example.chihirohaku.lab3_turn2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chihirohaku.lab3_turn2.models.Images;
import com.example.chihirohaku.lab3_turn2.models.MSalon;
import com.example.chihirohaku.lab3_turn2.models.Salon;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private String url = "http://a-server.herokuapp.com/api/salon";
//    ArrayList<Salon> salonArrayList = new ArrayList<>();
//    ArrayList<Images> imagesArrayList = new ArrayList<>();

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
                MSalon mSalon = gson.fromJson(body, MSalon.class);
                Log.d(TAG, mSalon.toString());
//                try {
//                    JSONObject jsonObject = new JSONObject(body);
//                    JSONArray jsonArray = jsonObject.getJSONArray("d");
//                    for (int i =0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                        String fanpage = jsonObject1.getString("Fanpage");
//                        String name = jsonObject1.getString("Name");
//                        String fanpageId = jsonObject1.getString("FanpageId");
//                        String manageName = jsonObject1.getString("ManagerName");
//                        String phone = jsonObject1.getString("Phone");
//                        int id = jsonObject1.getInt("Id");
//
//                        JSONArray jsonArray1 = jsonObject1.getJSONArray("Images");
//                        for (int j = 0; j < jsonArray1.length(); j++) {
//                            JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
//                            String url = jsonObject2.getString("url");
//                            String thumb = jsonObject2.getString("thumb");
//                            String descreption = jsonObject2.getString("description");
//                            String title = jsonObject2.getString("title");
//                            Images images = new Images(url, thumb, descreption, title);
//                            imagesArrayList.add(images);
//                            Log.d(TAG, jsonObject2.toString());
//                        }
//
//                        Salon salon = new Salon(fanpage, name, fanpageId, manageName, phone, imagesArrayList, id);
//                        salonArrayList.add(salon);
//
//                        Log.d(TAG, jsonObject1.toString());
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }
        });
    }
}
