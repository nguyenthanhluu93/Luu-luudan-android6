package luunt.lab2_turn5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by User on 11/21/2016.
 */

public class CircleView extends View {

    @BindColor(R.color.colorAccent) int colorAccent;
    @BindColor(R.color.colorPrimary) int colorPrimary;

    public CircleView(Context context) {
        super(context);
        ButterKnife.bind(this, this);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this, this);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(colorAccent);
        canvas.drawCircle(getWidth()/3, getHeight()/4, 300, p1);

        Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(colorPrimary);
        canvas.drawCircle((2 * getWidth()) / 3, getHeight()/4, 300, p2);
    }
}
