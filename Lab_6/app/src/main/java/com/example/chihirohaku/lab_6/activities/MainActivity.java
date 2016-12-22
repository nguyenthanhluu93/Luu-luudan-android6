package com.example.chihirohaku.lab_6.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.fragments.LoginFragment;

import static com.example.chihirohaku.lab_6.models.Account.DATA;
import static com.example.chihirohaku.lab_6.models.Account.TOKEN;

public class MainActivity extends BaseActivity {


    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EventBus.getDefault().register(this);

        SharedPreferences sharedPreferences = getSharedPreferences(DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(TOKEN, "");
        Log.d(TAG, String.format("%s", token));

        if (token.equals("")) {
            LoginFragment loginFragment = new LoginFragment();
            changeFragment(R.id.fl_oc, loginFragment, false, false);
        } else {
//            NoteFragment noteFragment = new NoteFragment();
//            changeFragment(R.id.fl_oc, noteFragment, false, false);
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivity(intent);
        }
    }

//    @Subscribe
//    public void onMessageEvent(OpenFragmentEvent openFragmentEvent) {
//        changeFragment(R.id.fl_oc, openFragmentEvent.getFragment(), openFragmentEvent.isAddToBackstack(), openFragmentEvent.isRemoveFromBackstack());
//    }
}
