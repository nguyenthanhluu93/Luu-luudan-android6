package com.luunt.lab2_turn4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_favorite)
    ListView lvFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        lvFavorite.setAdapter(new FavoriteAdapter(
                        this,
                        R.layout.item_list_favorite,
                        Arrays.asList(FavoriteItem.ARRAY)
         ));
    }
}
