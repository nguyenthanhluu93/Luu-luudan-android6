package com.example.chihirohaku.recycleviewintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chihirohaku.recycleviewintro.adapters.ContactAdaper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
        contactAdaper = new ContactAdaper();

        // 3: ....
        rvContact.setLayoutManager(new LinearLayoutManager(this));   // linearLayout, gridlayout, staggererGrid

        // 4: config recycleview
        rvContact.setAdapter(contactAdaper);
    }
}
