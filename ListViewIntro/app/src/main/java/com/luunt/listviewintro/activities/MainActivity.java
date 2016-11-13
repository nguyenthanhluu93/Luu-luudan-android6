package com.luunt.listviewintro.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.luunt.listviewintro.R;
import com.luunt.listviewintro.fragments.DetailFragment;
import com.luunt.listviewintro.fragments.OnStudentUpdateListener;
import com.luunt.listviewintro.models.Student;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements OnStudentUpdateListener {

    private static final String TAG = MainActivity.class.toString();
    private ListView lvStudent;

    private ArrayList<Student> students;
    private Button btnAdd;


    private ArrayAdapter<Student> stringArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students = Student.list;

        getReferences();
        setupUI();

    }

    @Override
    protected void onStart() {
        stringArrayAdapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        stringArrayAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    private void setupUI() {
        //create adapter
         stringArrayAdapter = new
                ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );
        lvStudent.setAdapter(stringArrayAdapter);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                Log.d(TAG, String.format("%s was tapped", students));

                if (findViewById(R.id.fr_detail) == null) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.POSITION_KEY, student);
                intent.putExtra(DetailActivity.OPERATION_KEY, Student.OP_UPDATE);
                startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(student, Student.OP_UPDATE);
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFrgment(R.id.fr_detail, detailFragment, true);

                }



            }
        });
        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                Log.d(TAG, String.format("%s was long clicked", student));
                students.remove(position);
                stringArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void getReferences() {
        lvStudent = (ListView) findViewById(R.id.lv_student);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.fr_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.OPERATION_KEY, Student.OP_ADD);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(null, Student.OP_ADD);
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFrgment(R.id.fr_detail, detailFragment, true);

                }
            }
        });
    }

    @Override
    public void onUpdate() {
        stringArrayAdapter.notifyDataSetChanged();
    }
}
