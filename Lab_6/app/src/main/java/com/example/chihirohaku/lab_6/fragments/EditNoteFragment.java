package com.example.chihirohaku.lab_6.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chihirohaku.lab_6.DBContext;
import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.Color;
import com.example.chihirohaku.lab_6.models.Note;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditNoteFragment extends Fragment {

    private static final String TAG = EditNoteFragment.class.toString();
    @BindView(R.id.edt_title)
    EditText edtTitle;
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.sp_color_list)
    Spinner spColor;
    @BindView(R.id.img_check)
    FloatingActionButton imgCheck;
    @BindView(R.id.fr_edit_note)
    RelativeLayout frEditNote;

    ArrayAdapter adapter;
    private String title, content, color;

    ArrayList<Color> colors = new ArrayList<>();

    Note note;

    public void setNote(Note note) {
        this.note = note;
    }

    public EditNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_note, container, false);
        ButterKnife.bind(this, view);
        initData();
        setupUI();
        return view;
    }

    private void initData() {
        colors.add(new Color("Yellow", "#FFFF00"));
        colors.add(new Color("Red", "#DD2C00"));
        colors.add(new Color("Blue", "#0091EA"));
        colors.add(new Color("Violet", "#EA80FC"));
        colors.add(new Color("Shit", "#CDDC39"));
        colors.add(new Color("Green", "#4CAF50"));
    }

    @OnClick(R.id.img_check)
    public void onCheckClick(View view) {
        title = edtTitle.getText().toString();
        content = edtContent.getText().toString();
        color = ((Color) spColor.getSelectedItem()).getKey();
        Note newNote = new Note(content, false, color, title);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Account.DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(Account.TOKEN, "");
        DBContext.getNoteEdit(newNote, token, note.getId().getoId()).enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                Note note = response.body();
                OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new ViewPagerNoteFragment(), false);
                EventBus.getDefault().post(openFragmentEvent);
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {

            }
        });
    }

    private void setupUI() {
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, colors);
        spColor.setAdapter(adapter);

        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                frEditNote.setBackgroundColor(android.graphics.Color.parseColor(((Color) spColor.getSelectedItem()).getKey()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        edtTitle.setText(note.getTitle());
        edtContent.setText(note.getContent());
        for (int i = 0; i < colors.size(); i++) {
            if (note.getColor().equalsIgnoreCase(colors.get(i).getKey())) {
                spColor.setSelection(i);
            }
        }
        frEditNote.setBackgroundColor(android.graphics.Color.parseColor(note.getColor()));
    }

}
