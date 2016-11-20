package com.luunt.butterknifeandeventbus;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OpenFragmentListener {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.tv_simple)
    TextView tvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        ButterKnife.bind(this);
        setupUI();
        openSimpleFragment();
    }

    private void openSimpleFragment() {
        SimpleFragment simpleFragment = new SimpleFragment();
        simpleFragment.setOpenFragmentListener(this);
        changeFrgment(simpleFragment, false, null);
    }

    private void changeFrgment(Fragment fragment, boolean addToBackstack, String tag) {
        if (addToBackstack) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .addToBackStack(tag)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }
    }

    private void setupUI() {
        tvSimple.setText("Hello Android 6");
    }

    @Override
    public void openFragment(Fragment fragment) {
//        changeFrgment(fragment);
    }

    @Subscribe
    public void onEvent(OpenFragmentEvent openFragmentEvent) {
        Log.d(TAG, "onEvent: OpenFragmentListener");
        changeFrgment(openFragmentEvent.getFragment(), openFragmentEvent.isAddToBackstack(), null);
    }
}
