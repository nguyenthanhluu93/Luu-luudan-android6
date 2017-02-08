package com.example.chihirohaku.musicapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.adapters.GenresLikedAdapter;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;
import com.example.chihirohaku.musicapp.services.RealmContext;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaylistFragment extends Fragment {

    @BindView(R.id.rv_list_genres_like)
    RecyclerView listGenresLike;
    GenresLikedAdapter genresLikedAdapter;
    public static List<SubgenresRealm> subgenresRealmsLiked;

    public PlaylistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        ButterKnife.bind(this, view);
        List<SubgenresRealm> subgenresRealms = RealmContext.getInstance().allSubgenres();
        subgenresRealmsLiked = new ArrayList<>();
        for (SubgenresRealm subgenresRealm : subgenresRealms) {
            if (subgenresRealm.isLike() == true) {
                Log.v("luulike", subgenresRealm.toString());
                subgenresRealmsLiked.add(subgenresRealm);
            }
        }
        setupUI();
        return view;
    }

    private void setupUI() {
        genresLikedAdapter = new GenresLikedAdapter();
        listGenresLike.setLayoutManager(new LinearLayoutManager(getActivity()));
        listGenresLike.setAdapter(genresLikedAdapter);
    }

}
