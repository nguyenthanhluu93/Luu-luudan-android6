package com.example.chihirohaku.lab_6.fragments;


import android.app.ProgressDialog;
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
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.BodyResponse;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.chihirohaku.lab_6.models.Account.DATA;
import static com.example.chihirohaku.lab_6.models.Account.TOKEN;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.toString();
    @BindView(R.id.edt_username)
    EditText edtUserName;
    @BindView(R.id.edt_pass)
    EditText edtPassWord;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    ProgressDialog progressDialog;

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
        progressDialog = new ProgressDialog(getContext());
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

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences(DATA, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(TOKEN, token);
                    editor.commit();
                    progressDialog.dismiss();
                    OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new NoteFragment(), false, false);
                    EventBus.getDefault().post(openFragmentEvent);
                }
            }

            @Override
            public void onFailure(Call<BodyResponse> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
    }

}
