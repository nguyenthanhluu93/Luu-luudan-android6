package com.example.chihirohaku.lab_6.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chihirohaku.lab_6.DBContext;
import com.example.chihirohaku.lab_6.R;
import com.example.chihirohaku.lab_6.adapters.NoteAdapter;
import com.example.chihirohaku.lab_6.eventbus.OpenFragmentEvent;
import com.example.chihirohaku.lab_6.models.Account;
import com.example.chihirohaku.lab_6.models.Note;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {

    private static final String TAG = NoteFragment.class.toString();


    @BindView(R.id.rv_note)
    RecyclerView rvNote;
    @BindView(R.id.img_add)
    FloatingActionButton imgAdd;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        ButterKnife.bind(this, view);

        initData();
        sendGET();
        return view;
    }

    @OnClick(R.id.img_add)
    public void onAddClick(View view) {
        OpenFragmentEvent openFragmentEvent = new OpenFragmentEvent(new CreateNoteFragment(), false, false);
        EventBus.getDefault().post(openFragmentEvent);
    }

    private void initData() {
        Note.notes = new ArrayList<Note>();
    }

    private void setupUI() {
        NoteAdapter noteAdapter = new NoteAdapter();
        rvNote.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvNote.setAdapter(noteAdapter);
    }

    public void sendGET() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Account.DATA, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(Account.TOKEN, "");
        DBContext.getNoteRepos(token).enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                Note.notes = (ArrayList<Note>) response.body();
                for (Note note : Note.notes) {
                    Log.d(TAG, note.toString());
                }
                setupUI();
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {
                Log.d(TAG, String.format("onFailure: %s", t));
            }
        });
    }



}
