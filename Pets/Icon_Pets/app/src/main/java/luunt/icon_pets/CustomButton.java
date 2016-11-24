package luunt.icon_pets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by User on 11/24/2016.
 */

public class CustomButton extends Button {

    public CustomButton(Context context) {
        super(context);
        init(context, null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton);
            String text = typedArray.getString(R.styleable.CustomButton_text);
            typedArray.recycle();
            if (text != null) {
                this.setText(text);
            }
            this.setTextColor(Color.WHITE);
            this.setBackgroundResource(R.drawable.deactivate_account_bg_red);
        }
    }
}
