package luunt.lab2_turn1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 11/21/2016.
 */

public class Player extends RelativeLayout {

    private static final String TAG = Player.class.toString();
    @BindView(R.id.img_add)
    ImageView imgAdd;
    @BindView(R.id.img_remove)
    ImageView imgRemove;
    @BindView(R.id.tv_number) CustomTextView tvNumber;
    @BindView(R.id.tv_title) CustomTextView tvTitle;

    private int number;
    private String title;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        updateUI();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        updateUI();
    }

    public Player(Context context) {
        super(context);
        initFromContext(context);
    }

    public Player(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context);
    }

    public Player(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context);
    }

    private void initFromContext(Context context) {
        View rootView = inflate(context, R.layout.player, this);
        ButterKnife.bind(this, rootView);
        updateUI();
        addListener();
    }

    private void addListener() {
        imgAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                number ++;
                Player.this.updateUI();
                Log.d(TAG, String.format("%s", number));
            }
        });
        imgRemove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                number --;
                Player.this.updateUI();
                Log.d(TAG, String.format("%s", number));
            }
        });
    }

    private void updateUI() {
//        tvNumber.setText(String.format("%s", number));
//        tvTitle.setText(String.format("%s %s", title, number));
    }
}
