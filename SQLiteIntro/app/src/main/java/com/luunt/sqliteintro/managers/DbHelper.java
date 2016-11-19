package com.luunt.sqliteintro.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luunt.sqliteintro.models.Note;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihirohaku on 11/15/2016.
 */
public class DbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "note.db";
    private static final int DB_VERSION = 1;

    /*==================Note constants====================*/

    private static final String NOTE_TABLE_NAME = "tbl_note";
    private static final String NOTE_ID_COLUMN = "id";
    private static final String NOTE_TITLE_COLUMN = "title";
    private static final String NOTE_CONTENT_COLUMN = "content";
    private static final String NOTE_DATE_CREATED_COLUMN = "date_created";
    private static final String[] NOTE_COLUMNS = {
            NOTE_ID_COLUMN,
            NOTE_TITLE_COLUMN,
            NOTE_CONTENT_COLUMN,
            NOTE_DATE_CREATED_COLUMN
    };

    /*===============Contructor and Singleton=================*/

    private DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static DbHelper instance;
    public static DbHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbHelper(context);
    }

    /*========================Note=======================*/

    public List<Note> selectAllNotes() {
        ArrayList<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NOTE_TABLE_NAME, NOTE_COLUMNS, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(NOTE_ID_COLUMN));
            String title = cursor.getString(cursor.getColumnIndex(NOTE_TITLE_COLUMN));
            String content = cursor.getString(cursor.getColumnIndex(NOTE_CONTENT_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(NOTE_DATE_CREATED_COLUMN));

            Note note = new Note(id, title, content, dateCreated);
            noteList.add(note);
        }
        db.close();
        return noteList;
    }

    public Note selectRandom() {
        SQLiteDatabase db = this.getReadableDatabase();
        Note note = null;
        String sql = "SELECT * FROM " + NOTE_TABLE_NAME + " ORDER BY RANDOM() LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex(NOTE_ID_COLUMN));
            String title = cursor.getString(cursor.getColumnIndex(NOTE_TITLE_COLUMN));
            String content = cursor.getString(cursor.getColumnIndex(NOTE_CONTENT_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(NOTE_DATE_CREATED_COLUMN));

            note = new Note(id, title, content, dateCreated);
        }
        db.close();
        return note;
    }

    public void insert(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        int id = (int) db.insert(NOTE_TABLE_NAME, null, create(note));
        note.setId(id);

        db.close();
    }

    public void delete(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.format("%s", note.getId())};

        db.delete(NOTE_TABLE_NAME, "id=?", args);  // ? = place holder

        db.close();
    }

    public void update(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.format("%s", note.getId())};
        db.update(NOTE_TABLE_NAME, create(note), "id=?", args);

        db.close();
    }

    private ContentValues create(Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTE_TITLE_COLUMN, note.getTitle());
        contentValues.put(NOTE_CONTENT_COLUMN, note.getContent());
        contentValues.put(NOTE_DATE_CREATED_COLUMN, note.getDateCreated());
        return  contentValues;
    }
}
