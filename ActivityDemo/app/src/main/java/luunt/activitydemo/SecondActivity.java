package luunt.activitydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.toString();
    private TextView tvNumOnCreate;
    private TextView tvNumOnStart;
    private TextView tvNumOnRestart;
    private TextView tvNumOnResume;
    private TextView tvNumOnPause;
    private TextView tvNumOnStop;
    private TextView tvNumOnDestroy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate");

        getReferences();
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
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
