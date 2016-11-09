package luunt.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_MIN = "key_min";
    private static final String KEY_SEC = "key_sec";
    private EditText edMin;
    private EditText edSec;
    private TextView tvCount;
    private Button btnStart;
    private Button btnStop;
    private int min;
    private int sec;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();

        if (savedInstanceState != null) {
            min = savedInstanceState.getInt(KEY_MIN, 0);
            sec = savedInstanceState.getInt(KEY_SEC, 0);
            tvCount.setText(String.format("%02d:%02d", min, sec));
            startTimer();
        }
    }

    private void getReferences() {
        edMin = (EditText) findViewById(R.id.ed_min);
        edSec = (EditText) findViewById(R.id.ed_sec);
        tvCount = (TextView) findViewById(R.id.tv_count);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                min = Integer.parseInt(edMin.getText().toString());
                sec = Integer.parseInt(edSec.getText().toString());
                startTimer();
                break;
            case R.id.btn_stop:
                stopTimer();
                break;
        }
    }

    private void stopTimer() {
        countDownTimer.cancel();
    }
    private void startTimer() {
        int time = (min * 60) + sec;
        countDownTimer = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvCount.setText(String.format("%02d:%02d", min, sec));
                sec--;
                if (sec <= 0) {
                    min--;
                    sec = 59;
                }

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_MIN, min);
        outState.putInt(KEY_SEC, sec);
    }
}
