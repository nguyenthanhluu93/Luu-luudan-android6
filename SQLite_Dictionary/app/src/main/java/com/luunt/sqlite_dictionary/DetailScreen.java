package com.luunt.sqlite_dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luunt.sqlite_dictionary.managers.DbHelper;
import com.luunt.sqlite_dictionary.models.Dictionary;

import java.util.List;

public class DetailScreen extends AppCompatActivity {

    private TextView tvOriginalWord;
    private TextView tvTranslatedWord;
    private TextView tvDateCreated;
    private TextView tvIsFavorite;
    private ImageView imgFavorite;

    int id;
    String original_word;
    String translated_word;
    String date_created;
    int favorite;
    Dictionary dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        getReferences();
        setupUI();
        addListener();

        Intent intent = getIntent();
        dictionary = (Dictionary) intent.getSerializableExtra(Dictionary.WORD);
        id = dictionary.getId();
        original_word = dictionary.getOriginal_word();
        translated_word = dictionary.getTranslated_word();
        date_created = dictionary.getDate_created();
        favorite = dictionary.getIs_favorite();

        getReferences();
        setupUI();
        addListener();
    }

    private void setupUI() {
        tvOriginalWord.setText(original_word);
        tvTranslatedWord.setText(translated_word);
        tvDateCreated.setText(date_created);
        if (favorite == 1) {
            imgFavorite.setImageResource(R.drawable.ic_favorited);
        } else {
            imgFavorite.setImageResource(R.drawable.ic_favorite);
        }
    }


    private void addListener() {
        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = DbHelper.getInstance();
                if (favorite == 1) {
                    dictionary.setIs_favorite(0);
                    dbHelper.update(dictionary);
                    imgFavorite.setImageResource(R.drawable.ic_favorite);
                } else {
                    dictionary.setIs_favorite(1);
                    dbHelper.update(dictionary);
                    imgFavorite.setImageResource(R.drawable.ic_favorited);
                }
            }
        });
    }

    private void getReferences() {
        tvOriginalWord = (TextView) findViewById(R.id.txt_original_word);
        tvTranslatedWord = (TextView) findViewById(R.id.txt_translated_word);
        tvDateCreated = (TextView) findViewById(R.id.txt_date_created);
        tvIsFavorite = (TextView) findViewById(R.id.tv_is_favorite);
        imgFavorite = (ImageView) findViewById(R.id.img_favorite);
    }
}
