package com.example.chihirohaku.musicapp.eventbus;

import com.example.chihirohaku.musicapp.models.Entry;
import com.example.chihirohaku.musicapp.models.SongRealm;

/**
 * Created by Chihirohaku on 1/14/2017.
 */

public class ShowMiniEvent {
    private boolean isShow;
    private SongRealm songRealm;

    public ShowMiniEvent(boolean isShow, SongRealm songRealm) {
        this.isShow = isShow;
        this.songRealm = songRealm;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public SongRealm getSongRealm() {
        return songRealm;
    }

    public void setSongRealm(SongRealm songRealm) {
        this.songRealm = songRealm;
    }
}
