package com.example.chihirohaku.realmintroinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chihirohaku.realmintroinclass.databases.DbContext;
import com.example.chihirohaku.realmintroinclass.databases.models.Person;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbContext.init(this);

        for (Person person : DbContext.getInstance().allPerson()) {
            Log.d(TAG, person.getName());
        }

    }

}
