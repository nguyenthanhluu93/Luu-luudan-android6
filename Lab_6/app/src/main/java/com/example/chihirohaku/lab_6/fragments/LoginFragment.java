package com.example.chihirohaku.lab_6.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.chihirohaku.lab_6.DBContext;
import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.Status;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public static final String DATA = "my_sharepreferences";
    public static final String TOKEN = "key_token";
    @BindView(R.id.edt_username)
    EditText edtUserName;
    @BindView(R.id.edt_pass)
    EditText edtPassWord;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        return view;

    }

    @OnClick(R.id.btn_register)
    public void onRegisterClick(View view) {
        String username = edtUserName.getText().toString();
        String password = edtPassWord.getText().toString();
        Account account = new Account(username, password);
        DBContext.getRegisterBody(account).enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Log.d("oc", "dmdmdmdmdmdmdmd");
                if (response.code() == 201) {
                    Status status = response.body();
                    Log.d("oc", status.toString());
                } else {
                    Log.d("oc", "dm tuan oc cho");
                }

            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick(View view) {
        Log.d("oc", "dm tuan oc cho");
        String userName = edtUserName.getText().toString();
        String pass = edtPassWord.getText().toString();
        Account account = new Account(userName, pass);
        DBContext.getLoginBody(account).enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (response.code() == 201) {
                    Status status = response.body();
                    String token = response.body().getToken();
                    Log.d("token", String.format("%s", token));
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences(DATA, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(TOKEN, token);
                    editor.commit();
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {

            }
        });
    }

}
