package com.luunt.sqlite_dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.luunt.sqlite_dictionary.managers.DbHelper;
import com.luunt.sqlite_dictionary.models.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private DbHelper dbHelper;
    private SearchView edtInput;
    private ListView lvDictionary;
    private ArrayAdapter<Dictionary> adapter;
    ArrayList<Dictionary> dictionaryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dbHelper = DbHelper.getInstance();

        getReferences();
        setupUI();
        addListener();

//        testInsert();
//        testDelete();
//        testUpdate();
        testSelectAll();
        testSelectRandom();
        testSelectWordByWord();
        testSelectWordIsFavorite();
    }

    @Override
    protected void onStart() {
        adapter.notifyDataSetChanged();
        super.onStart();
    }

    private void addListener() {
        edtInput.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = edtInput.getQuery().toString();
                dictionaryList = (ArrayList<Dictionary>) dbHelper.selectWordByWord(text);
                for (Dictionary dictionary : dictionaryList) {
                    Log.d(TAG, dictionary.toString());
                }
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, dictionaryList);
                lvDictionary.setAdapter(adapter);
                return true;
            }
        });

        lvDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dictionary dictionary = dictionaryList.get(position);
                Intent intent = new Intent(MainActivity.this, DetailScreen.class);
                intent.putExtra(Dictionary.WORD, dictionary);
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        dictionaryList = (ArrayList<Dictionary>) dbHelper.selectAllWord();
        for (Dictionary dictionary : dictionaryList) {
            Log.d(TAG, dictionary.toString());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dictionaryList);
        lvDictionary.setAdapter(adapter);
    }

    private void getReferences() {
        edtInput = (SearchView) findViewById(R.id.edt_input_text);
        lvDictionary = (ListView) findViewById(R.id.lv_dictionary);
    }

    private void testSelectWordIsFavorite() {
        List<Dictionary> dictionaryList = dbHelper.selectWordIsFavorite();
        for (Dictionary dictionary : dictionaryList) {
            Log.d("Is Favorite", dictionary.toString());
        }
    }

    private void testSelectWordByWord() {
        List<Dictionary> dictionaryList = dbHelper.selectWordByWord("d");
        for (Dictionary dictionary : dictionaryList) {
            Log.d(TAG, dictionary.toString());
        }
    }

    private void testSelectRandom() {
        Dictionary dictionary = dbHelper.selectRandom();
        Log.d("Select Random", dictionary.toString());

    }

    private void testUpdate() {
        List<Dictionary> dictionaryList = dbHelper.selectAllWord();
        if (dictionaryList.size() > 0) {
            dictionaryList.get(6).setOriginal_word("Update original word");
            dictionaryList.get(6).setTranslated_word("Update translated word");
            dictionaryList.get(6).setIs_favorite(0);
            dbHelper.update(dictionaryList.get(6));
        }
    }

    private void testDelete() {
        List<Dictionary> dictionaryList = dbHelper.selectAllWord();
        if (dictionaryList.size() > 0) {
            dbHelper.delete(dictionaryList.get(9));
        }
    }

    private void testInsert() {
        Dictionary dictionary = new Dictionary("cut", "cut", "2015-12-11", 0);
        dbHelper.insert(dictionary);
        Log.d(TAG, String.format("%s", dictionary));
    }

    private void testSelectAll() {
        List<Dictionary> dictionaryList = dbHelper.selectAllWord();
        for (Dictionary dictionary : dictionaryList) {
            Log.d(TAG, dictionary.toString());
        }
    }

}
