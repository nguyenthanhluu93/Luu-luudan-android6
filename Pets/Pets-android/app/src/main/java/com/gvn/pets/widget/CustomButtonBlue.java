package com.gvn.pets.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

import com.gvn.pets.R;

/**
 * Created by User on 11/28/2016.
 */

public class CustomButtonBlue extends Button {
    public CustomButtonBlue(Context context) {
        super(context);
        init(context, null);
    }

    public CustomButtonBlue(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomButtonBlue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButtonBlue);
            String text = typedArray.getString(R.styleable.CustomButtonBlue_value);
            typedArray.recycle();
            if (text != null) {
                this.setText(text);
            }
            this.setTextColor(Color.WHITE);
            this.setBackgroundResource(R.drawable.bg_btn_blue);
        }
    }
}
