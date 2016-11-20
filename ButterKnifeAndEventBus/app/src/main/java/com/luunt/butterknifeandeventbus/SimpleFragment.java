package com.luunt.butterknifeandeventbus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    private static final String TAG = SimpleFragment.class.toString();
    @BindView(R.id.btn_ok)
    Button btnOK;
    @BindColor(R.color.colorAccent) int colorAccent;

    private OpenFragmentListener openFragmentListener;

    public void setOpenFragmentListener(OpenFragmentListener openFragmentListener) {
        this.openFragmentListener = openFragmentListener;
    }

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        ButterKnife.bind(this, view);

        setupUI();
        return view;
    }

    private void setupUI() {
        btnOK.setBackgroundColor(colorAccent);
    }

    @OnClick(R.id.btn_ok)
    public void onButtonOKClick(View v) {
        Log.d(TAG, "onButtonOKClick");
//        if (openFragmentListener != null) {
//            openFragmentListener.openFragment(new VerySimpleFragment());
//        } else {
//            Log.d(TAG, "openFragmentListener is null");
//        }

        // publisher
        OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new VerySimpleFragment(), true);
        EventBus.getDefault().post(openFragmentEvent);
    }

}
