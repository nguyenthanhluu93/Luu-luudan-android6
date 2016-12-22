package com.example.chihirohaku.lab_6.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.Note;

import org.greenrobot.eventbus.EventBus;

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
public class CreateNoteFragment extends Fragment {

    private static final String TAG = CreateNoteFragment.class.toString();
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
    private String title, content, color;

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
        title = edtTitle.getText().toString();
        content = edtContent.getText().toString();
        Note note = new Note(content, false, color, title);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Account.DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(Account.TOKEN, "");
        DBContext.getNoteBody(note, token).enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                List<Note> notes = response.body();
                for (Note note1 : notes) {
                    Log.d(TAG, note1.toString());
                }
                OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new CreateNoteFragment(), false, true);
                EventBus.getDefault().post(openFragmentEvent);
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
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
                        color = "#FFFF00";
                        break;
                    case 1:
                        frCreateNote.setBackgroundColor(red);
                        color = "#DD2C00";
                        break;
                    case 2:
                        frCreateNote.setBackgroundColor(blue);
                        color = "#0091EA";
                        break;
                    case 3:
                        frCreateNote.setBackgroundColor(violet);
                        color = "#EA80FC";
                        break;
                    case 4:
                        frCreateNote.setBackgroundColor(shit);
                        color = "#CDDC39";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
