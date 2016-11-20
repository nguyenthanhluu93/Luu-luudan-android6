package com.luunt.ondrawdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class CustomTextView extends TextView {

    @BindColor(R.color.blue) int colorBlue;

    public CustomTextView(Context context) {
        super(context);
        ButterKnife.bind(this, this);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this, this);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(colorBlue);
        int width = getWidth();
        int height = getHeight();
        canvas.drawRect(new Rect(0, 0, width, height), p);
    }
}
