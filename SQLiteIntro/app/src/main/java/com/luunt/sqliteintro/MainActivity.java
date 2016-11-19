package com.luunt.sqliteintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.luunt.sqliteintro.managers.DbHelper;
import com.luunt.sqliteintro.models.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate");

        this.dbHelper = DbHelper.getInstance();

        testInsert();
        testDelete();
        testUpdate();
        testSelectAll();
        testSelectRandom();
    }

    private void testSelectRandom() {
        Note note = dbHelper.selectRandom();
        Log.d(TAG, String.format("item select random: ", note.toString()));

    }

    private void testUpdate() {
        List<Note> noteList = dbHelper.selectAllNotes();
        if (noteList.size() > 0) {
            noteList.get(0).setContent("Update content");
            noteList.get(0).setTitle("Update title");
            dbHelper.update(noteList.get(0));
        }
    }

    private void testDelete() {
        List<Note> noteList = dbHelper.selectAllNotes();
        if (noteList.size() > 0) {
            dbHelper.delete(noteList.get(0));
        }
    }

    private void testInsert() {
        Note note = new Note("cut", "cut", "2015-12-11");
        dbHelper.insert(note);
        Log.d(TAG, String.format("%s", note));
    }

    private void testSelectAll() {
        List<Note> noteList = dbHelper.selectAllNotes();
        for (Note note : noteList) {
            Log.d(TAG, note.toString());
        }
    }
}
