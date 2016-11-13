package com.luunt.simplelistnote.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.luunt.simplelistnote.R;
import com.luunt.simplelistnote.models.Note;

public class DetailFragment extends Fragment {

    private Note note;
    private int operation;

    private OnNoteUpdateListener onStudentUpdateListener;

    private EditText tvName;
    private Button btnSave;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setOnStudentUpdateListener(OnNoteUpdateListener onStudentUpdateListener) {
        this.onStudentUpdateListener = onStudentUpdateListener;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        getReferences(view);
        setupUI();
        addListener();

        return view;
    }

    public static DetailFragment create(Note note, int operation) {
        //1: create
        DetailFragment detailFragment = new DetailFragment();
        //2: (optional) pass arg
        detailFragment.setNote(note);
        detailFragment.setOperation(operation);

        return detailFragment;
    }

    private void addListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation == Note.OP_UPDATE) {
                    note.setName(tvName.getText().toString());

                    if (onStudentUpdateListener != null) {
                        onStudentUpdateListener.onUpdate();
                    }
                } else if (operation == Note.OP_ADD) {
                    Note note = new Note();
                    note.setName(tvName.getText().toString());
                    Note.list.add(note);
                    if (onStudentUpdateListener != null) {
                        onStudentUpdateListener.onUpdate();
                    }
                }
            }
        });
    }

    private void setupUI() {
        if (operation == Note.OP_UPDATE) {
            tvName.setText(note.getName());
        }
    }

    private void getReferences(View view) {
        tvName = (EditText) view.findViewById(R.id.tv_name);
        btnSave = (Button) view.findViewById(R.id.btn_save);
    }

}
