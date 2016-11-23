package com.luunt.testlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private EditText edtUserName;
    private EditText edtPass;
    private Button btnLogin;

    private String url = "https://a5-tumblelog.herokuapp.com/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        addListener();
    }

    private void addListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                String username = edtUserName.getText().toString();
                String pass = edtPass.getText().toString();
                final Login login = new Login(username, pass);
                Gson gson = new Gson();
                String data = gson.toJson(login);
                RequestBody requestBody = RequestBody.create(JSON, data);
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
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
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            final int code = jsonObject.getInt("code");
                            final String message = jsonObject.getString("message");
                            Log.d(TAG, String.format("Code: %s, %s", code, message));
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this,
                                            String.format("Code: %s, %s", code, message),
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void getReferences() {
        edtUserName = (EditText) findViewById(R.id.edt_username);
        edtPass = (EditText) findViewById(R.id.edt_pass);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
