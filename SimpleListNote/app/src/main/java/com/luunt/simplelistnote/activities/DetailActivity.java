package com.luunt.simplelistnote.activities;

import android.content.Intent;
import android.os.Bundle;

import com.luunt.simplelistnote.R;
import com.luunt.simplelistnote.fragment.DetailFragment;
import com.luunt.simplelistnote.fragment.OnNoteUpdateListener;
import com.luunt.simplelistnote.models.Note;

public class DetailActivity extends BaseActivity implements OnNoteUpdateListener {

    public static final String POSITION_KEY = "position";
    public static final String OPERATION_KEY = "operation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
//        int position = intent.getIntExtra(POSITION_KEY, -1);
        int operation = intent.getIntExtra(OPERATION_KEY, -1);

        Note note = (Note) intent.getSerializableExtra(POSITION_KEY);
        if (note != null) {
//            student = Note.list.get(position);

            DetailFragment detailFragment = DetailFragment.create(note, operation);
            detailFragment.setOnStudentUpdateListener(this);

            changeFrgment(R.id.fr_detail, detailFragment, false);


        }
    }


    @Override
    public void onUpdate() {
        finish();
    }
}
