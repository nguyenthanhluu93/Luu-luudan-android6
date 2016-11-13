package com.luunt.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private EditText etName;
    private TextView tvHello;
    private Button btnSayHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRefeferences();
        addListeners();

    }

    private void addListeners() {
        btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // logcat
                Log.d(TAG, "onClick");
                String name = etName.getText().toString();
                String sayHello = String.format("Hello %s", name);
                tvHello.setText(sayHello);
            }
        });
    }

    private void getRefeferences() {
        etName = (EditText) findViewById(R.id.et_name);
        tvHello = (TextView) findViewById(R.id.tv_hello);
        btnSayHello = (Button) findViewById(R.id.btn_say_hello);
    }
}
