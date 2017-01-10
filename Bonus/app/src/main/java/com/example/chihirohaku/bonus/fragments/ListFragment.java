package com.example.chihirohaku.bonus.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chihirohaku.bonus.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    @BindView(R.id.btn_go_to_detail)
    Button btnGoToDetail;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_go_to_detail)
    public void goToDetail() {
        FragmentEvent fragmentEvent = new FragmentEvent(new DetailFragment(), true);
        EventBus.getDefault().post(fragmentEvent);
    }

}
