package luunt.lab2_turn5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.seek_bar)
    DiscreteSeekBar seekBar;
    @BindView(R.id.btn_change)
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         setupUI();
    }

    private void setupUI() {
        seekBar.setMin(1);
        seekBar.setMax(100);
        seekBar.setProgress(30);
    }

    @OnClick(R.id.btn_change)
    public void btnChangeOnClick(View v) {
        seekBar.setProgress(seekBar.getProgress() + 20);
    }
}
