package com.example.chihirohaku.musicapp.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.adapters.SongAdapter;
import com.example.chihirohaku.musicapp.eventbus.ShowMiniEvent;
import com.example.chihirohaku.musicapp.eventbus.UpdateRecyclerView;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;
import com.example.chihirohaku.musicapp.services.RealmContext;
import com.example.chihirohaku.musicapp.services.RetrofitContext;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopSongFragment extends Fragment {

    private static final String TAG = TopSongFragment.class.toString();

    @BindView(R.id.img_back) ImageView imgBack;
    @BindView(R.id.img_search) ImageView imgSearch;
    @BindView(R.id.img_favorite) ImageView imgFavorite;
    @BindView(R.id.img_share) ImageView imgShare;
    @BindView(R.id.img_music) ImageView imgMusic;
    @BindView(R.id.tv_name_type_music) TextView tvNameType;
    @BindView(R.id.tv_number_music) TextView tvNumberSong;
    @BindView(R.id.img_play_music)
    FloatingActionButton btnPlayMusic;
    @BindView(R.id.rv_list_music)
    RecyclerView listMusic;
    private SongAdapter songAdapter;

    private SubgenresRealm subgenres;

    public void setSubgenres(SubgenresRealm subgenres) {
        this.subgenres = subgenres;
    }

    public TopSongFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_song, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        RetrofitContext.getAllSongByType(subgenres);

        setupUI();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subgenres.isLike()) {
                    imgFavorite.setImageResource(R.drawable.ic_heart_outline);
                    RealmContext.getInstance().updateGenresLike(subgenres, false);
                } else {
                    imgFavorite.setImageResource(R.drawable.ic_heart);
                    RealmContext.getInstance().updateGenresLike(subgenres, true);
                }
            }
        });
        return view;
    }

    public void setupUI() {
        tvNameType.setText(subgenres.getNameSubgenres());
        String name = "genre_" + subgenres.getId();
        int id  = getContext().getResources().getIdentifier( name, "drawable", getContext().getPackageName());
        Picasso.with(getContext()).load(id).into(imgMusic);
        if (subgenres.isLike()) {
            imgFavorite.setImageResource(R.drawable.ic_heart);
        } else {
            imgFavorite.setImageResource(R.drawable.ic_heart_outline);
        }
        songAdapter = new SongAdapter();
        songAdapter.setSubgenresRealm(subgenres);
        listMusic.setLayoutManager(new LinearLayoutManager(getActivity()));
        listMusic.setAdapter(songAdapter);
        btnPlayMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMiniEvent showMiniFragment = new ShowMiniEvent(true, subgenres.getSongRealmList().get(0));
                EventBus.getDefault().post(showMiniFragment);
            }
        });
    }

    @Subscribe
    public void onUpdateRecyclerView(UpdateRecyclerView updateRecyclerView) {

        songAdapter.notifyDataSetChanged();
        tvNumberSong.setText(String.format("%s songs", subgenres.getSongRealmList().size()));
    }

}
