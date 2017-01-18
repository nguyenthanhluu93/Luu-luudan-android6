package com.example.chihirohaku.musicapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.eventbus.ShowMiniEvent;
import com.example.chihirohaku.musicapp.models.Entry;
import com.example.chihirohaku.musicapp.models.SongRealm;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiniPlayerFragment extends Fragment {

    @BindView(R.id.mini_player_img_music)
    CircleImageView imgMusic;
    @BindView(R.id.mini_player_name)
    TextView tvName;
    @BindView(R.id.mini_player_autor)
    TextView tvAutor;


    public MiniPlayerFragment() {
        // Required empty public constructor
    }

    public static MiniPlayerFragment newInstance() {

        Bundle args = new Bundle();

        MiniPlayerFragment fragment = new MiniPlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mini_player, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    public void setupUI(SongRealm songRealm){
        Picasso.with(getContext()).load(songRealm.getUrlImageSong()).into(imgMusic);
        tvName.setText(songRealm.getSongName());
        tvAutor.setText(songRealm.getArtistName());
    }

    @Subscribe(sticky = true)
    public void onShowMiniFragment(ShowMiniEvent showMiniEvent) {
        if (showMiniEvent.isShow()) {
            getActivity().findViewById(R.id.fragment_mini_player).setVisibility(View.VISIBLE);
        } else {
            getActivity().findViewById(R.id.fragment_mini_player).setVisibility(View.GONE);
        }
        setupUI(showMiniEvent.getSongRealm());
    }

}