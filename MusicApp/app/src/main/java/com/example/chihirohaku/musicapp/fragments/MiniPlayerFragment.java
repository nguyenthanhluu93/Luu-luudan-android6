package com.example.chihirohaku.musicapp.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.eventbus.ShowMiniEvent;
import com.example.chihirohaku.musicapp.models.Entry;
import com.example.chihirohaku.musicapp.models.SongRealm;
import com.example.chihirohaku.musicapp.services.MusicContext;
import com.example.chihirohaku.musicapp.services.RetrofitContext;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import hybridmediaplayer.Hybrid;

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
    @BindView(R.id.mini_player_play_music)
    ImageView imgPlayMusic;
    @BindView(R.id.mini_player_seekbar)
    SeekBar seekBar;
    Handler handler = new Handler();

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
        RetrofitContext.getDataSong(songRealm, getContext());
        updateSeekbar();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                if (fromUser) {
                    updateSeekbar();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @OnClick(R.id.mini_player_play_music)
    public void onClick(View view) {
        if (MusicContext.getInstance(getContext()).isPlaying()) {
            imgPlayMusic.setBackgroundResource(R.drawable.ic_play_circle_filled_black_24px);
            MusicContext.getInstance(getContext()).pauseMusic();
        } else {
            imgPlayMusic.setBackgroundResource(R.drawable.ic_pause_circle_filled_black_24px);
            MusicContext.getInstance(getContext()).resumeMusic();
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(MusicContext.getInstance(getContext()).getSeekbarCurrentPosition());
            handler.postDelayed(runnable, 1000);
        }
    };

    public void updateSeekbar() {
        handler.postDelayed(runnable, 1000);
        seekBar.setMax(MusicContext.getInstance(getContext()).getSeekbarDuration());
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