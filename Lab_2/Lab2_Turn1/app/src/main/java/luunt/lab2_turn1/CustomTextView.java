package luunt.lab2_turn1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 11/21/2016.
 */

public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
        initFrom(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context, attrs);
    }

    private void initFrom(Context context, AttributeSet attrs) {
        if (attrs != null) {
            // 1: lay ra bo attribute
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);

            // 2
            int number = typedArray.getInt(R.styleable.CustomTextView_number, -1);
            String title = typedArray.getString(R.styleable.CustomTextView_title);

            // 3:
            typedArray.recycle();

            // 4: day time len giao dien
            if (number != -1) {
                this.setText(String.format("%s", number));
            }
            if (title != null) {
                this.setText(title);
            }
        }
    }

}
