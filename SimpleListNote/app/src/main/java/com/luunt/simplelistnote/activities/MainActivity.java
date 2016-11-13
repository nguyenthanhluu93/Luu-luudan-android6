package com.luunt.simplelistnote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.luunt.simplelistnote.R;

import com.luunt.simplelistnote.fragment.DetailFragment;
import com.luunt.simplelistnote.fragment.OnNoteUpdateListener;
import com.luunt.simplelistnote.models.Note;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements OnNoteUpdateListener {

    private static final String TAG = MainActivity.class.toString();
    private ListView lvNote;

    private ArrayList<Note> notes;
    private Button btnAdd;


    private ArrayAdapter<Note> noteArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes = Note.list;

        getReferences();
        setupUI();

    }

    @Override
    protected void onStart() {
        noteArrayAdapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        noteArrayAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    private void setupUI() {
        //create adapter
        noteArrayAdapter = new
                ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                notes
        );
        lvNote.setAdapter(noteArrayAdapter);

        lvNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = notes.get(position);
                Log.d(TAG, String.format("%s was tapped", note));

                if (findViewById(R.id.fr_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.POSITION_KEY, note);
                    intent.putExtra(DetailActivity.OPERATION_KEY, Note.OP_UPDATE);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(note, Note.OP_UPDATE);
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFrgment(R.id.fr_detail, detailFragment, true);

                }


            }
        });
        lvNote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = notes.get(position);
                Log.d(TAG, String.format("%s was long clicked", note));
                notes.remove(position);
                noteArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void getReferences() {
        lvNote = (ListView) findViewById(R.id.lv_student);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.fr_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.OPERATION_KEY, Note.OP_ADD);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(null, Note.OP_ADD);
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFrgment(R.id.fr_detail, detailFragment, true);

                }
            }
        });
    }

    @Override
    public void onUpdate() {
        noteArrayAdapter.notifyDataSetChanged();
    }
}
