package com.gvn.pets.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by namIT on 11/30/2016.
 */

public class FontTextView extends AppCompatTextView {

    public FontTextView(Context context) {
        super(context);
        initView(context, null, 0);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "MyriadPro-Regular.otf");
        setTypeface(tf, Typeface.NORMAL);
    }
}
