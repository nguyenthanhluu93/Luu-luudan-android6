package com.example.chihirohaku.musicapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.activities.MainActivity;
import com.example.chihirohaku.musicapp.adapters.MusicPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicViewPagerFragment extends Fragment {

    @BindView(R.id.vp_music)
    ViewPager vpMusic;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private MusicPagerAdapter musicPagerAdapter;

    public MusicViewPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        musicPagerAdapter = new MusicPagerAdapter(getActivity().getSupportFragmentManager());
        vpMusic.setAdapter(musicPagerAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_view_pager, container, false);
        ButterKnife.bind(this, view);
        musicPagerAdapter = new MusicPagerAdapter(getActivity().getSupportFragmentManager());
        vpMusic.setAdapter(musicPagerAdapter);
        return view;
    }

}
