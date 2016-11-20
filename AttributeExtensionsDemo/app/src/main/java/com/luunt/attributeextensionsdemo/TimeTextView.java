package com.luunt.attributeextensionsdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class TimeTextView extends TextView {

    public TimeTextView(Context context) {
        super(context);
        initFrom(context, null);
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context, attrs);
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context, attrs);
    }

    private void initFrom(Context context, AttributeSet attrs) {
        if (attrs != null) {
            // 1: lay ra bo attribute
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeTextView);

            // 2
            int time = typedArray.getInt(R.styleable.TimeTextView_time, -1);


            // 3:
            typedArray.recycle();

            // 4: day time len giao dien
            if (time != -1) {
                this.setText(String.format("%s", fromSecondToTimeString(time)));
            }
        }
    }

    String fromSecondToTimeString(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
