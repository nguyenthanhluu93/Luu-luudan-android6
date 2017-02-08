package com.example.chihirohaku.musicapp.services;

import android.content.Context;
import android.os.Handler;
import android.widget.SeekBar;

import hybridmediaplayer.Hybrid;

/**
 * Created by Chihirohaku on 2/7/2017.
 */

public class MusicContext {

    private Hybrid hybrid;
    private Context context;

    public MusicContext(Context context) {
        this.context = context;
        hybrid = Hybrid.getInstance(context);
    }

    public void playMusic(String linkSource) {
        if (hybrid.isPlaying()) {
            hybrid.release();
            hybrid = Hybrid.getInstance(context);
        }
        hybrid.setDataSource(linkSource);
        hybrid.prepare();
        hybrid.play();
    }

    public int getSeekbarCurrentPosition() {
        return hybrid.getCurrentPosition();
    }

    public int getSeekbarDuration() {
        return hybrid.getDuration();
    }

    public void pauseMusic() {
        hybrid.pause();
    }

    public void resumeMusic() {
        hybrid.play();
    }

    public boolean isPlaying() {
        return hybrid.isPlaying();
    }

    private static MusicContext instance;

    public static MusicContext getInstance(Context context) {
        if (instance == null) {
            instance = new MusicContext(context);
        }
        return instance;
    }
}
