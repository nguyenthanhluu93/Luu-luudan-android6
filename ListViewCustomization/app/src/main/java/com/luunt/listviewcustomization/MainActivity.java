package com.luunt.listviewcustomization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_fashion_menu) ListView lvFashionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        lvFashionMenu.setAdapter(new FashionAdapter(
                this,
                R.layout.listview_item_fashion,
                Arrays.asList(FashionItem.ARRAY)));
    }
}
