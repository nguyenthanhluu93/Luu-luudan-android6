package com.example.chihirohaku.recycleviewintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.chihirohaku.recycleviewintro.adapters.ContactAdaper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IOnRecyclerListener {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.rv_contact)
    RecyclerView rvContact;

    private ContactAdaper contactAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupUI();
    }

    private void setupUI() {

        // 2: prepare adapter
        contactAdaper = new ContactAdaper(this);

        // 3: ....
        rvContact.setLayoutManager(new LinearLayoutManager(this));   // linearLayout, gridlayout, staggererGrid

        // 4: config recycleview
        rvContact.setAdapter(contactAdaper);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, String.format("onItemClick: %s", position));
    }
}
