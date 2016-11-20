package com.luunt.onmeasuredemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class SquareRelativeLayout extends RelativeLayout {

    private static final String TAG = SquareRelativeLayout.class.toString();

    public SquareRelativeLayout(Context context) {
        super(context);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* Dieu chinh ti le cua layout/view */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        Log.d(TAG, String.format("widthSize: %s", widthSize));
        int heightSize = widthSize;  // height ti le voi width (vd: height = 2*width ...)
        int heightMode = MeasureSpec.EXACTLY;   // mode: EXACTLY/UNSPECIFIED
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, heightMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
