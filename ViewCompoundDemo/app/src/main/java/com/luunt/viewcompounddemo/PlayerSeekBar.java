package com.luunt.viewcompounddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class PlayerSeekBar extends RelativeLayout {

    private static final String TAG = PlayerSeekBar.class.toString();
    private int timeInTotal;
    private int timePassed;

    @BindView(R.id.sb_value)
    public SeekBar sbValue;

    @BindView(R.id.tv_time_passed)
    public TextView tvTimePassed;

    @BindView(R.id.tv_time_left)
    public TextView tvTimeLeft;

    public PlayerSeekBar(Context context) {
        super(context);
        initFromContext(context);
    }

    public PlayerSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context);
    }

    public PlayerSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context);
    }

    public int getTimeInTotal() {
        return timeInTotal;
    }

    public void setTimeInTotal(int timeInTotal) {
        this.timeInTotal = timeInTotal;
        updateUI();
    }

    public int getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
        updateUI();
    }

    private void updateUI() {
        int timeLeft = timeInTotal - timePassed;
        tvTimePassed.setText(String.format("%s", toTimeString(timePassed)));
        tvTimeLeft.setText(String.format("%s", toTimeString(timeLeft)));
        sbValue.setMax(timeInTotal);
        sbValue.setProgress(timePassed);
    }

    private String toTimeString(int seconds) {
        return String.format("%2s:%2s", (seconds / 60) % 60, seconds % 60);
    }

    private void addListener() {
        sbValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    timePassed = sbValue.getProgress();
                    timeInTotal = sbValue.getMax();
                    PlayerSeekBar.this.updateUI();
                    Log.d(TAG, String.format("%s, %s", progress, fromUser));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initFromContext(Context context) {
        View rootView = inflate(context, R.layout.player_seekbar, this);
        ButterKnife.bind(this, rootView);
        updateUI();
        addListener();
    }


}
