package com.example.chihirohaku.musicapp.activities;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.chihirohaku.musicapp.R;
import com.example.chihirohaku.musicapp.fragments.MusicViewPagerFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayShowHomeEnabled(false);
        this.getSupportActionBar().setDisplayShowTitleEnabled(true);

        changeFragment(R.id.fr_content, new MusicViewPagerFragment(), false);
//        int[] color = new int[] {Color.parseColor("#59000000"), Color.parseColor("#00000000")};
//        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, color);
//        getSupportActionBar().setBackgroundDrawable(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
