package com.example.chihirohaku.lab_6.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.fragments.LoginFragment;
import com.example.chihirohaku.lab_6.fragments.NoteFragment;
import com.example.chihirohaku.lab_6.models.Note;

import static com.example.chihirohaku.lab_6.models.Account.DATA;
import static com.example.chihirohaku.lab_6.models.Account.TOKEN;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends BaseActivity {


    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        SharedPreferences sharedPreferences = getSharedPreferences(DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(TOKEN, "");
        Log.d(TAG, String.format("%s", token));

//        if (token == null) {
            LoginFragment loginFragment = new LoginFragment();
            changeFragment(R.id.fl_oc, loginFragment);
//        } else {
//            NoteFragment noteFragment = new NoteFragment();
//            changeFragment(R.id.fl_oc, noteFragment);
//        }
    }

    @Subscribe
    public void onMessageEvent(OpenFragmentEvent openFragmentEvent) {
        changeFragment(R.id.fl_oc, openFragmentEvent.getFragment());
    }
}
