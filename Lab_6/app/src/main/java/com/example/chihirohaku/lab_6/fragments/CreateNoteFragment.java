package com.example.chihirohaku.lab_6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chihirohaku.lab_6.DBContext;
import com.example.chihirohaku.lab_6.R;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNoteFragment extends Fragment {

    @BindView(R.id.edt_create_title)
    TextView edtTitle;
    @BindView(R.id.edt_create_content)
    TextView edtContent;
    @BindView(R.id.sp_color)
    Spinner spColor;
    @BindView(R.id.img_check)
    ImageView imgCheck;
    @BindView(R.id.fr_create_note)
    FrameLayout frCreateNote;
    @BindColor(R.color.yellow) int yellow;
    @BindColor(R.color.red) int red;
    @BindColor(R.color.blue) int blue;
    @BindColor(R.color.violet) int violet;
    @BindColor(R.color.shit) int shit;

    String[] COLORS = new String[] {"Yellow", "Red", "Blue", "Violet", "Shit"};
    ArrayAdapter adapter;

    public CreateNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_note, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    @OnClick(R.id.img_check)
    public void onCheckClick(View view) {
        String title = edtTitle.getText().toString();
        String content = edtContent.getText().toString();
        S
        DBContext.
    }

    private void setupUI() {
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, COLORS);
        spColor.setAdapter(adapter);
        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        frCreateNote.setBackgroundColor(yellow);
                        break;
                    case 1:
                        frCreateNote.setBackgroundColor(red);
                        break;
                    case 2:
                        frCreateNote.setBackgroundColor(blue);
                        break;
                    case 3:
                        frCreateNote.setBackgroundColor(violet);
                        break;
                    case 4:
                        frCreateNote.setBackgroundColor(shit);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
