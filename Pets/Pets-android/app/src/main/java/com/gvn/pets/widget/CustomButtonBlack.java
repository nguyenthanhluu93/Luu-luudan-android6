package com.gvn.pets.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import com.gvn.pets.R;

/**
 * Created by User on 11/24/2016.
 */

public class CustomButtonBlack extends Button {

    public CustomButtonBlack(Context context) {
        super(context);
        init(context, null);
    }

    public CustomButtonBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomButtonBlack(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButtonBlack);
            String text = typedArray.getString(R.styleable.CustomButtonBlack_text);
            typedArray.recycle();
            if (text != null) {
                this.setText(text);
            }
            this.setBackgroundResource(R.drawable.sign_up_bg_black);
        }
    }
}
