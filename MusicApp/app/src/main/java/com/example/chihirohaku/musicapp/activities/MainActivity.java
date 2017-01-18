package com.example.chihirohaku.musicapp.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.musicapp.fragments.MusicViewPagerFragment;
import com.example.chihirohaku.musicapp.services.RealmContext;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity {

    View layoutMiniPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RealmContext.init(this);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        changeFragment(R.id.fr_content, new MusicViewPagerFragment(), false, true);
        layoutMiniPlayer = findViewById(R.id.fragment_mini_player);
        layoutMiniPlayer.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Subscribe
    public void onEvent(OpenFragmentEvent openFragmentEvent) {
        changeFragment(R.id.fr_content, openFragmentEvent.getFragment(),
                openFragmentEvent.isAddToBackstack(),
                openFragmentEvent.isShowToolbar());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            getSupportActionBar().show();
        }
        layoutMiniPlayer.setVisibility(View.GONE);
    }
}
