package com.example.chihirohaku.musicapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.adapters.MusicAdapter;
import com.example.chihirohaku.musicapp.models.ResponseMusic;
import com.example.chihirohaku.musicapp.models.Subgenres;
import com.example.chihirohaku.musicapp.services.DBContext;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenresFragment extends Fragment {

    private static final String TAG = GenresFragment.class.toString();
    @BindView(R.id.rv_list_music)
    RecyclerView rvListMusics;
    MusicAdapter musicAdapter;

    public GenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genres, container, false);
        ButterKnife.bind(this, view);
        getAllMusic();
        setupUI();
        return view;
    }

    private void setupUI() {
        musicAdapter = new MusicAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position % 3 == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        rvListMusics.setLayoutManager(layoutManager);
        rvListMusics.setAdapter(musicAdapter);
    }

    private void getAllMusic() {
        DBContext.getMusicsRepos().enqueue(new Callback<List<ResponseMusic>>() {
            @Override
            public void onResponse(Call<List<ResponseMusic>> call, Response<List<ResponseMusic>> response) {
                List<ResponseMusic> responseMusicList = response.body();
                for (ResponseMusic responseMusic : responseMusicList) {
                    if (responseMusic.getId() == 34) {
                        Subgenres.setSubgenresList(responseMusic.getSubgenres());
                        Log.d(TAG, responseMusic.getSubgenres().toString());
                    }
                }
                setupUI();
            }

            @Override
            public void onFailure(Call<List<ResponseMusic>> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
    }

}
