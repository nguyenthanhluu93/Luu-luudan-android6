package com.luunt.listviewintro.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.luunt.listviewintro.R;
import com.luunt.listviewintro.fragments.DetailFragment;
import com.luunt.listviewintro.fragments.OnStudentUpdateListener;
import com.luunt.listviewintro.models.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailActivity extends BaseActivity implements OnStudentUpdateListener {

    public static final String POSITION_KEY = "position";
    public static final String OPERATION_KEY = "operation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
//        int position = intent.getIntExtra(POSITION_KEY, -1);
        int operation = intent.getIntExtra(OPERATION_KEY, -1);

        Student student = (Student) intent.getSerializableExtra(POSITION_KEY);
        if (student != null) {
//            student = Student.list.get(position);

            DetailFragment detailFragment = DetailFragment.create(student, operation);
            detailFragment.setOnStudentUpdateListener(this);

            changeFrgment(R.id.fr_detail, detailFragment, false);


        }
    }


    @Override
    public void onUpdate() {
        finish();
    }
}
