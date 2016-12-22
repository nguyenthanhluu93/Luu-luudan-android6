package com.example.chihirohaku.lab_6.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.adapters.NotePagerAdapter;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteActivity extends BaseActivity {

    @BindView(R.id.vp_Note)
    ViewPager vpNote;
    private NotePagerAdapter notePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        notePagerAdapter = new NotePagerAdapter(getSupportFragmentManager());
        vpNote.setAdapter(notePagerAdapter);
    }

    @Subscribe
    public void onMessageEvent(OpenFragmentEvent openFragmentEvent) {
        changeFragment(R.id.fr_note, openFragmentEvent.getFragment(), openFragmentEvent.isAddToBackstack(), openFragmentEvent.isRemoveFromBackstack());
    }

}
