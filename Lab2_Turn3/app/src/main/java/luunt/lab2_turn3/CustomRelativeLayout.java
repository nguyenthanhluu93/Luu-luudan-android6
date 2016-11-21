package luunt.lab2_turn3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by User on 11/21/2016.
 */

public class CustomRelativeLayout extends RelativeLayout {

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthParent = MeasureSpec.getSize(getWidth());
        int width = widthMeasureSpec/2;
        int widthMode = MeasureSpec.EXACTLY;
        int newWidth = MeasureSpec.makeMeasureSpec(width, widthMode);
        super.onMeasure(newWidth, heightMeasureSpec);
    }
}
