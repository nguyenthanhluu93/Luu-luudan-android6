package com.luunt.demoactivity;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private static final String NUMBER_OF_TAPS_KEY = "numberOfTaps";
    private Button btnGo2nd, btnGo3rd, btnFinish;
    private int numberOfTaps;
    private Button btTapMe;
    TextView tvNumberOfTaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        if (savedInstanceState != null) {
            numberOfTaps = savedInstanceState.getInt(NUMBER_OF_TAPS_KEY, 0);
        }

        tvNumberOfTaps = (TextView) findViewById(R.id.tv_number_of_taps);
        tvNumberOfTaps.setText(String.format("Number of taps: %s", numberOfTaps));

        btnGo2nd = (Button) findViewById(R.id.go_2nd);
        btnGo3rd = (Button) findViewById(R.id.go_3rd);
        btnFinish = (Button) findViewById(R.id.btn_finish);
        btnGo2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to 2nd activity
                //1: create an intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //2: change activity
                startActivity(intent);
            }
        });

        btnGo3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                MainActivity.this.finish();
            }
        });

        btTapMe = (Button) findViewById(R.id.bt_tap_me);
        btTapMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTaps++;
                tvNumberOfTaps.setText(String.format("Number of taps: %s", numberOfTaps));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(NUMBER_OF_TAPS_KEY, numberOfTaps);
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
