package com.example.chihirohaku.lab_6.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.adapters.NotePagerAdapter;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerNoteFragment extends Fragment {

    @BindView(R.id.vp_Note)
    ViewPager vpNote;
    @BindView(R.id.img_add)
    FloatingActionButton imgAdd;
    @BindColor(R.color.green) int green;
    @BindColor(R.color.white) int white;
    @BindColor(R.color.black) int black;

    private NotePagerAdapter notePagerAdapter;

    public ViewPagerNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager_note, container, false);
        ButterKnife.bind(this, view);
        notePagerAdapter = new NotePagerAdapter(getActivity().getSupportFragmentManager());
        vpNote.setAdapter(notePagerAdapter);
        return view;
    }

    @OnClick(R.id.img_add)
    public void onAddClick(View view) {
        OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new CreateNoteFragment(), true);
        EventBus.getDefault().post(openFragmentEvent);
    }

}
