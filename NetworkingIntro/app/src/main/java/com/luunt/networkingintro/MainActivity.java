package com.luunt.networkingintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.luunt.networkingintro.jsonmodels.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private ListView lvPost;
    private ArrayAdapter<Post> postArrayAdapter;
    private ArrayList<Post> postList;

    String url = "https://a5-tumblelog.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        getReferences();
        configUI();

        sendGET();
        sendPOST();
    }


    private void sendPOST() {
        // 1 create client
        OkHttpClient client = new OkHttpClient();

        //2: create post body
        //2.1: MediaType
        // 2.2: data
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Post post = new Post("luu", "luuuuuuuuuuuuu");
        Gson gson = new Gson();
        String data = gson.toJson(post);
//        String data = " {\n" +
//                "    \"content\": \"codethechange123\",\n" +
//                "    \"title\": \"we don't takl anymore ahihi\"\n" +
//                "  }";
        RequestBody requestBody = RequestBody.create(JSON, data);

        //3: create request
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        // send request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure: %s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("onResponse: %s ", body));
            }
        });
    }

    private void sendGET() {
        // 1: create a client
        OkHttpClient client = new OkHttpClient();

        // 2: create a request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // 3: send request
        // sync (1) va Async (2)
        // use Async (2)
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure: %s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse");
                String body = response.body().string(); // chi duoc dung 1 lan
                Log.d(TAG, String.format("onResponse: %s", body));

                Gson gson = new Gson();
                Post[] posts = gson.fromJson(body, Post[].class);   // Post.class (if json don

                // update models
                postList.clear();
                postList.addAll(Arrays.asList(posts));

                // come back to main thread and update UIs
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // upadate views
                        postArrayAdapter.notifyDataSetChanged();
                    }
                });

//                for (Post post : posts) {
//                    Log.d(TAG, String.format("%s, %s", post.getTitle(), post.getContent()));
//                }
            }
        });
    }

    private void initData() {
        postList = new ArrayList<>();
    }

    private void configUI() {
        postArrayAdapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, postList);
        lvPost.setAdapter(postArrayAdapter);
    }

    private void getReferences() {
        lvPost = (ListView) findViewById(R.id.lv_post);
    }
}
