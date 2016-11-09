package luunt.activitydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.toString();

    private static final String KEY_NUM_CREATE = "num_create";
    private static final String KEY_NUM_START = "num_start";
    private static final String KEY_NUM_RESTART = "num_restart";
    private static final String KEY_NUM_RESUME = "num_resume";
    private static final String KEY_NUM_PAUSE = "num_pause";
    private static final String KEY_NUM_STOP = "num_stop";
    private static final String KEY_NUM_DESTROY = "num_destroy";

    private TextView tvNumOnCreate;
    private TextView tvNumOnStart;
    private TextView tvNumOnRestart;
    private TextView tvNumOnResume;
    private TextView tvNumOnPause;
    private TextView tvNumOnStop;
    private TextView tvNumOnDestroy;

    private int countStart = 0;
    private int countCreate = 0;
    private int countRestart = 0;
    private int countResume = 0;
    private int countPause = 0;
    private int countStop = 0;
    private int countDestroy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate");

        getReferences();
        countCreate++;
        tvNumOnCreate.setText(String.format("%s", countCreate));
        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(KEY_NUM_CREATE, 0);
            tvNumOnCreate.setText(String.format("%s", count));
            tvNumOnStart.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_START, 0)));
            tvNumOnRestart.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_RESTART, 0)));
            tvNumOnResume.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_RESUME, 0)));
            tvNumOnPause.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_PAUSE, 0)));
            tvNumOnStop.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_STOP, 0)));
            tvNumOnDestroy.setText(String.format("%s", savedInstanceState.getInt(KEY_NUM_DESTROY, 0)));
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
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
        countStart++;
        tvNumOnStart.setText(String.format("%s ", countStart));
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
        countRestart++;
        tvNumOnStart.setText(String.format("%s ", countRestart));
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        countResume++;
        tvNumOnStart.setText(String.format("%s ", countResume));
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        countPause++;
        tvNumOnStart.setText(String.format("%s ", countPause));
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
        countStop++;
        tvNumOnStart.setText(String.format("%s ", countStop));
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        countDestroy++;
        tvNumOnStart.setText(String.format("%s ", countDestroy));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUM_CREATE, countCreate);
        outState.putInt(KEY_NUM_START, countStart);
        outState.putInt(KEY_NUM_RESTART, countRestart);
        outState.putInt(KEY_NUM_RESUME, countResume);
        outState.putInt(KEY_NUM_PAUSE, countPause);
        outState.putInt(KEY_NUM_STOP, countStop);
        outState.putInt(KEY_NUM_DESTROY, countDestroy);
    }
}
