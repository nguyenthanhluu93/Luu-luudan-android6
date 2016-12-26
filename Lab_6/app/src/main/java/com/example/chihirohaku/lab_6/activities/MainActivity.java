package com.example.chihirohaku.lab_6.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chihirohaku.lab_6.DBContext;
import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.BodyResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.chihirohaku.lab_6.models.Account.DATA;
import static com.example.chihirohaku.lab_6.models.Account.TOKEN;

public class MainActivity extends BaseActivity {

    @BindView(R.id.edt_username)
    EditText edtUserName;
    @BindView(R.id.edt_pass)
    EditText edtPassWord;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    ProgressDialog progressDialog;

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences = getSharedPreferences(DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(TOKEN, "");
        Log.d(TAG, String.format("%s", token));

        if (!token.equals("")) {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.btn_register)
    public void onRegisterClick(View view) {
        String username = edtUserName.getText().toString();
        String password = edtPassWord.getText().toString();
        Account account = new Account(username, password);
        DBContext.getRegisterBody(account).enqueue(new Callback<BodyResponse>() {
            @Override
            public void onResponse(Call<BodyResponse> call, Response<BodyResponse> response) {
                Log.d("oc", "dmdmdmdmdmdmdmd");
                if (response.code() == 201) {
                    BodyResponse status = response.body();
                    Log.d("oc", status.toString());
                } else {
                    Log.d("oc", "dm tuan oc cho");
                }
            }

            @Override
            public void onFailure(Call<BodyResponse> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        Log.d("oc", "dm tuan oc cho");
        String userName = edtUserName.getText().toString();
        String pass = edtPassWord.getText().toString();
        Account account = new Account(userName, pass);
        DBContext.getLoginBody(account).enqueue(new Callback<BodyResponse>() {
            @Override
            public void onResponse(Call<BodyResponse> call, Response<BodyResponse> response) {
                if (response.code() == 201) {
                    BodyResponse status = response.body();
                    String token = response.body().getToken();
                    Log.d("token", String.format("%s", token));

                    SharedPreferences sharedPreferences = getSharedPreferences(DATA, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(TOKEN, token);
                    editor.commit();
                    progressDialog.dismiss();

                    Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<BodyResponse> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
