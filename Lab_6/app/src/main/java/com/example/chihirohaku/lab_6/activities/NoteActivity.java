package com.example.chihirohaku.lab_6.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.adapters.NotePagerAdapter;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.fragments.ViewPagerNoteFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        changeFragment(R.id.fr_note, new ViewPagerNoteFragment(), false);
    }

    @Subscribe
    public void onMessageEvent(OpenFragmentEvent openFragmentEvent) {
        changeFragment(R.id.fr_note, openFragmentEvent.getFragment(), openFragmentEvent.isAddToBackstack());
    }
}
