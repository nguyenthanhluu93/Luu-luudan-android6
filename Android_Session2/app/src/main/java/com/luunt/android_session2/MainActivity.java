package com.luunt.android_session2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ImageView imgShit;
    private Spinner spFruits;
    private EditText etShit;
    private Button btnTest;
    private CheckBox chFa;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioButton rbUndefined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
        addListener();

    }

    private void getReferences() {
        imgShit = (ImageView) findViewById(R.id.img_shit);
        spFruits = (Spinner) findViewById(R.id.sp_fruits);
        etShit = (EditText) findViewById(R.id.et_shit);
        btnTest = (Button) findViewById(R.id.btn_test);
        chFa = (CheckBox) findViewById(R.id.ch_Fa);
        rbMale = (RadioButton) findViewById(R.id.rb_male);
        rbFemale = (RadioButton) findViewById(R.id.rb_female);
        rbUndefined = (RadioButton) findViewById(R.id.rb_undefined);
    }

    private void setupUI() {
        imgShit.setImageResource(R.drawable.shit);

        String[] fruits = new String[] {
                "Apple",
                "Orange",
                "Banana",
                "Shit"
        };
        ArrayAdapter<String> fruitsArrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits
        );
        spFruits.setAdapter(fruitsArrayAdapter);

        spFruits.post(new Runnable() {
            @Override
            public void run() {
                spFruits.setSelection(2);
            }
        });

        rbMale.setChecked(true);

        etShit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void addListener() {
        spFruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("%s %d", "spFruits.onItemSelected", position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "onNothingSelected");
            }
        });

        chFa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("chFA.onCheckedChanged: %s", isChecked));
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read
                Log.d(TAG, String.format("cbFA: %s", chFa.isChecked()));
                //write
                chFa.setChecked(!chFa.isChecked());

                //read value of radiobutton
                Log.d(TAG, rbMale.isChecked()? "Male" : rbFemale.isChecked()? "Female" : "Undefines");
            }
        });
    }

}
