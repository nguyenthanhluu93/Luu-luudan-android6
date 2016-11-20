package com.luunt.listviewcustomization;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Chihirohaku on 11/20/2016.
 */
public class FashionRelativeLayout extends RelativeLayout {

    public FashionRelativeLayout(Context context) {
        super(context);
    }

    public FashionRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FashionRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = widthSize/2;
        int heightMode = MeasureSpec.EXACTLY;
        int newHeightMesureSpec = MeasureSpec.makeMeasureSpec(heightSize, heightMode);

        super.onMeasure(widthMeasureSpec, newHeightMesureSpec);
    }
}
