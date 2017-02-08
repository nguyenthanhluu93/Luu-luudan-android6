package com.example.chihirohaku.musicapp.services;

import android.content.Context;
import android.util.Log;

import com.example.chihirohaku.musicapp.eventbus.UpdateRecyclerView;
import com.example.chihirohaku.musicapp.models.Entry;
import com.example.chihirohaku.musicapp.models.RequestData;
import com.example.chihirohaku.musicapp.models.ResponseDataSong;
import com.example.chihirohaku.musicapp.models.ResponseMusic;
import com.example.chihirohaku.musicapp.models.ResponseSong;
import com.example.chihirohaku.musicapp.models.SongRealm;
import com.example.chihirohaku.musicapp.models.Subgenres;
import com.example.chihirohaku.musicapp.models.SubgenresRealm;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import hybridmediaplayer.Hybrid;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class RetrofitContext {
    public static final Retrofit GETMUSIC_RETROFIT = new Retrofit.Builder()
            .baseUrl("https://rss.itunes.apple.com/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final Retrofit GETSONG_RETROFIT = new Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/us/rss/topsongs/limit=50/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final Retrofit SONG_RETROFIT = new Retrofit.Builder()
            .baseUrl("http://api.mp3.zing.vn/api/mobile/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Call<List<ResponseMusic>> getMusicsRepos() {
        return GETMUSIC_RETROFIT.create(GetAllMusicServices.class).getAllMusic();
    }

    public static Call<ResponseSong> getAllSongRepos(String id) {
        return GETSONG_RETROFIT.create(GetSongMusicServices.class).getAllSongByType(id);
    }

    public static Call<ResponseDataSong> getDataSongRepos(String requestdata) {
        return SONG_RETROFIT.create(GetDataSongServices.class).getTopMusic(requestdata);
    }

    public static void getAllSubgenres() {
        RetrofitContext.getMusicsRepos().enqueue(new Callback<List<ResponseMusic>>() {
            @Override
            public void onResponse(Call<List<ResponseMusic>> call, Response<List<ResponseMusic>> response) {
                List<ResponseMusic> responseMusicList = response.body();
                Log.d("tuanoc", responseMusicList.toString());
                if (RealmContext.getInstance().allSubgenres().size() == 0) {
                    List<SubgenresRealm> subgenresRealmList = new ArrayList<SubgenresRealm>();
                    for (ResponseMusic responseMusic : responseMusicList) {
                        if (responseMusic.getId() == 34) {
                            List<Subgenres> subgenresList = responseMusic.getSubgenres();
                            for (int i = 0; i< subgenresList.size(); i++) {
                                SubgenresRealm subgenresRealm = new SubgenresRealm();
                                subgenresRealm.setId(subgenresList.get(i).getId_img());
                                subgenresRealm.setNameSubgenres(subgenresList.get(i).getTranslationKey());
                                subgenresRealmList.add(subgenresRealm);
                            }
                        }
                    }
                    RealmContext.getInstance().insert(subgenresRealmList);
                    UpdateRecyclerView updateRecyclerView = new UpdateRecyclerView();
                    EventBus.getDefault().post(updateRecyclerView);
                } else {
                    RealmContext.getInstance().allSubgenres();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseMusic>> call, Throwable t) {
                Log.d("luunt", String.format("onFailure: %s", t));
                RealmContext.getInstance().allSubgenres();
                Log.d("luunt123", String.format(RealmContext.getInstance().allSubgenres().toString()));
            }
        });
    }

    public static void getAllSongByType(final SubgenresRealm subgenresRealm) {
        RetrofitContext.getAllSongRepos(subgenresRealm.getId()).enqueue(new Callback<ResponseSong>() {
            @Override
            public void onResponse(Call<ResponseSong> call, Response<ResponseSong> response) {
                ResponseSong responseSong = response.body();
                Log.d("tuanoc111111111", responseSong.toString());
                RealmList<SongRealm> songRealmList = new RealmList<SongRealm>();
                List<Entry> listSong = responseSong.getFeed().getEntries();
                for (Entry entry : listSong) {
                    SongRealm songRealm = new SongRealm();
                    songRealm.setSongName(entry.getImName().getLabel());
                    songRealm.setUrlImageSong(entry.getImImages().get(2).getLabel());
                    songRealm.setArtistName(entry.getImArtist().getLabel());
                    songRealmList.add(songRealm);
                }
                RealmContext.getInstance().updateSongToGenres(subgenresRealm, songRealmList);
                List<SongRealm> list = subgenresRealm.getSongRealmList();
                for(SongRealm songRealm: list){
                    Log.d("luuham", songRealm.toString());
                }
                UpdateRecyclerView updateRecyclerView = new UpdateRecyclerView();
                EventBus.getDefault().post(updateRecyclerView);
            }

            @Override
            public void onFailure(Call<ResponseSong> call, Throwable t) {
                Log.d("tuanoc", String.format("onFailure: %s", t));
                List<SongRealm> list = subgenresRealm.getSongRealmList();
                for(SongRealm songRealm: list){
                    Log.d("luuham", songRealm.toString());
                }
                UpdateRecyclerView updateRecyclerView = new UpdateRecyclerView();
                EventBus.getDefault().post(updateRecyclerView);
            }
        });
    }

    public static void getDataSong(SongRealm songRealm, final Context context) {
        RequestData requestData = new RequestData(songRealm);
        RetrofitContext.getDataSongRepos(requestData.toString()).enqueue(new Callback<ResponseDataSong>() {
            @Override
            public void onResponse(Call<ResponseDataSong> call, Response<ResponseDataSong> response) {
                ResponseDataSong responseDataSong = response.body();
                String linkSource = responseDataSong.getDocses().get(1).getSource().getLinkSource().toString();
                MusicContext.getInstance(context).playMusic(linkSource);
                Log.d("aaaaa", responseDataSong.toString());
            }

            @Override
            public void onFailure(Call<ResponseDataSong> call, Throwable t) {

            }
        });
    }
}
