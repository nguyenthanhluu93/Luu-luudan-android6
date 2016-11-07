package luunt.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private static final String KEY_NUM_ON_CREATE = "num_on_create";
    private static final String KEY_NUM_ON_START = "num_on_start";
    private static final String KEY_NUM_ON_RESTART = "num_on_restart";
    private static final String KEY_NUM_ON_RESUME = "num_on_resume";
    private static final String KEY_NUM_ON_PAUSE = "num_on_pause";
    private static final String KEY_NUM_ON_STOP = "num_on_stop";
    private static final String KEY_NUM_ON_DESTROY = "num_on_destroy";

    private TextView tvNumOnCreate;
    private TextView tvNumOnStart;
    private TextView tvNumOnRestart;
    private TextView tvNumOnResume;
    private TextView tvNumOnPause;
    private TextView tvNumOnStop;
    private TextView tvNumOnDestroy;
    private Button btnGo2nd;

    private int countOnStart = 0;
    private int countOnCreate = 0;
    private int countOnRestart = 0;
    private int countResume = 0;
    private int countPause = 0;
    private int countStop = 0;
    private int countDestroy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        getReferences();
        countOnCreate++;
        tvNumOnCreate.setText(String.format("%s", countOnCreate));
        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(KEY_NUM_ON_CREATE, 0);
            tvNumOnCreate.setText(String.format("%s", count));
            tvNumOnStart.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_ON_START, 0)));
            tvNumOnRestart.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_ON_RESTART, 0)));
            tvNumOnResume.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_ON_RESUME, 0)));
            tvNumOnPause.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_ON_PAUSE, 0)));
            tvNumOnStop.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_ON_STOP, 0)));
            tvNumOnDestroy.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_ON_DESTROY, 0)));
        }

    }

    private void getReferences() {
        tvNumOnCreate = (TextView) findViewById(R.id.tv_num_onCreate);
        tvNumOnStart = (TextView) findViewById(R.id.tv_num_onStart);
        tvNumOnRestart = (TextView) findViewById(R.id.tv_num_onRestart);
        tvNumOnResume = (TextView) findViewById(R.id.tv_num_onResume);
        tvNumOnPause = (TextView) findViewById(R.id.tv_num_onPause);
        tvNumOnStop = (TextView) findViewById(R.id.tv_num_onStop);
        tvNumOnDestroy = (TextView) findViewById(R.id.tv_num_onDestroy);
        btnGo2nd = (Button) findViewById(R.id.btn_go_activity_b);
        btnGo2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        countOnStart++;
        tvNumOnStart.setText(String.format("%s ", countOnStart));
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        countOnRestart++;
        tvNumOnRestart.setText(String.format("%s", countOnRestart));
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        countResume++;
        tvNumOnResume.setText(String.format("%s", countResume));
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        countPause++;
        tvNumOnPause.setText(String.format("%s", countPause));
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        countStop++;
        tvNumOnStop.setText(String.format("%s", countStop));
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        countDestroy++;
        tvNumOnDestroy.setText(String.format("%s", countDestroy));
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_NUM_ON_CREATE, countOnCreate);
        outState.putInt(KEY_NUM_ON_START, countOnStart);
        outState.putInt(KEY_NUM_ON_RESTART, countOnRestart);
        outState.putInt(KEY_NUM_ON_RESUME, countResume);
        outState.putInt(KEY_NUM_ON_PAUSE, countPause);
        outState.putInt(KEY_NUM_ON_STOP, countStop);
        outState.putInt(KEY_NUM_ON_DESTROY, countDestroy);
        super.onSaveInstanceState(outState);
    }
}
