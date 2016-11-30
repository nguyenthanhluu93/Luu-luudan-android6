package com.nankai.designlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.nankai.designlayout.R;
import com.nankai.designlayout.utils.Utils;

/**
 * Created by namIT on 9/13/2016.
 */
public class TextProgressBar extends ProgressBar {
    private String text;
    private Paint textPaint;

    public TextProgressBar(Context context) {
        super(context);
        initView(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.text_progress_bar);
        float textSize = a.getDimension(R.styleable.text_progress_bar_progressBarTextSize, Utils.pixelsToSp(18, context));
        text = getProgress() + "%";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(Math.round(textSize));
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        // First draw the regular progress bar, then custom draw our text
        super.onDraw(canvas);
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        int x = getWidth() / 2 - bounds.centerX();
        int y = getHeight() / 2 - bounds.centerY();
        canvas.drawText(text, x, y, textPaint);
    }

    public synchronized void setText(String text) {
        this.text = text;
        drawableStateChanged();
    }

    public void setTextColor(int color) {
        textPaint.setColor(color);
        drawableStateChanged();
    }
}