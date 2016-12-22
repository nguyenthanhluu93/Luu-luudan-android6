package com.example.chihirohaku.lab_6.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.chihirohaku.lab_6.fragments.NoteFragment;

/**
 * Created by User on 12/22/2016.
 */

public class NotePagerAdapter extends FragmentStatePagerAdapter {

    private int NUMBER_PAGES = 2;

    public NotePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NoteFragment();
            case 1:
                return new NoteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "In progress";
            case 1:
                return "Completed";
            default:
                return null;
        }
    }
}
