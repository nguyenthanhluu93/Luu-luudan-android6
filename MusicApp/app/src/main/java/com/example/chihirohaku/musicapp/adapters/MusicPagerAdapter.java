package com.example.chihirohaku.musicapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.chihirohaku.musicapp.fragments.GenresFragment;
import com.example.chihirohaku.musicapp.fragments.OfflineFragment;
import com.example.chihirohaku.musicapp.fragments.PlaylistFragment;

/**
 * Created by Chihirohaku on 1/10/2017.
 */

public class MusicPagerAdapter extends FragmentStatePagerAdapter {

    public static final int NUMBER_COUNT = 3;

    public MusicPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GenresFragment();
            case 1:
                return new PlaylistFragment();
            case 2:
                return new OfflineFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Genres";
            case 1:
                return "Playlist";
            case 2:
                return "Offline";
            default:
                return null;
        }
    }
}
