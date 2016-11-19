package com.luunt.sqlite_dictionary.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luunt.sqlite_dictionary.models.Dictionary;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihirohaku on 11/15/2016.
 */
public class DbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "dictionary.db";
    private static final int DB_VERSION = 1;

    /*==================Note constants====================*/

    private static final String DICTIONARY_TABLE_NAME = "tbl_word";
    private static final String DICTIONARY_ID_COLUMN = "id";
    private static final String DICTIONARY_ORIGINAL_WORD_COLUMN = "original_word";
    private static final String DICTIONARY_TRANSLATED_WORD_COLUMN = "translated_word";
    private static final String DICTIONARY_DATE_CREATED_COLUMN = "date_created";
    private static final String DICTIONARY_IS_FAVORITE = "is_favorite";
    private static final String[] DICTIONARY_COLUMNS = {
            DICTIONARY_ID_COLUMN,
            DICTIONARY_ORIGINAL_WORD_COLUMN,
            DICTIONARY_TRANSLATED_WORD_COLUMN,
            DICTIONARY_DATE_CREATED_COLUMN,
            DICTIONARY_IS_FAVORITE
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

    public List<Dictionary> selectAllWord() {
        ArrayList<Dictionary> dictionaryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, DICTIONARY_COLUMNS, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));

            Dictionary dictionary = new Dictionary(id, originalWord, translatedWord, dateCreated, isFavorite);
            dictionaryList.add(dictionary);
        }
        db.close();
        return dictionaryList;
    }

    public List<Dictionary> selectWordByWord(String word){
        ArrayList<Dictionary> dictionaryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + DICTIONARY_TABLE_NAME + " where " + DICTIONARY_ORIGINAL_WORD_COLUMN + " like '%"+word+"%'";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));

            Dictionary dictionary = new Dictionary(id, originalWord, translatedWord, dateCreated, isFavorite);
            dictionaryList.add(dictionary);
        }
        db.close();
        return dictionaryList;
    }

    public List<Dictionary> selectWordIsFavorite(){
        ArrayList<Dictionary> dictionaryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + DICTIONARY_TABLE_NAME + " where " + DICTIONARY_IS_FAVORITE + " = 1";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));

            Dictionary dictionary = new Dictionary(id, originalWord, translatedWord, dateCreated, isFavorite);
            dictionaryList.add(dictionary);
        }
        db.close();
        return dictionaryList;
    }

    public Dictionary selectRandom() {
        SQLiteDatabase db = this.getReadableDatabase();
        Dictionary dictionary = null;
        String sql = "SELECT * FROM " + DICTIONARY_TABLE_NAME + " ORDER BY RANDOM() LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE));

            dictionary = new Dictionary(id, originalWord, translatedWord, dateCreated, isFavorite);
        }
        db.close();
        return dictionary;
    }

    public void insert(Dictionary dictionary) {
        SQLiteDatabase db = this.getWritableDatabase();

        int id = (int) db.insert(DICTIONARY_TABLE_NAME, null, create(dictionary));
        dictionary.setId(id);

        db.close();
    }

    public void delete(Dictionary dictionary) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.format("%s", dictionary.getId())};

        db.delete(DICTIONARY_TABLE_NAME, "id=?", args);  // ? = place holder

        db.close();
    }

    public void update(Dictionary dictionary) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] args = new String[] {String.format("%s", dictionary.getId())};
        db.update(DICTIONARY_TABLE_NAME, create(dictionary), "id=?", args);

        db.close();
    }

    private ContentValues create(Dictionary dictionary) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DICTIONARY_ORIGINAL_WORD_COLUMN, dictionary.getOriginal_word());
        contentValues.put(DICTIONARY_TRANSLATED_WORD_COLUMN, dictionary.getTranslated_word());
        contentValues.put(DICTIONARY_DATE_CREATED_COLUMN, dictionary.getDate_created());
        contentValues.put(DICTIONARY_IS_FAVORITE, dictionary.getIs_favorite());
        return  contentValues;
    }
}
