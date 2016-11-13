package com.luunt.listviewintro.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.luunt.listviewintro.R;
import com.luunt.listviewintro.models.Student;

public class DetailFragment extends Fragment {

    private Student student;
    private int operation;

    private OnStudentUpdateListener onStudentUpdateListener;

    private EditText tvName;
    private EditText tvGender;
    private EditText tvAge;
    private Button btnSave;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setOnStudentUpdateListener(OnStudentUpdateListener onStudentUpdateListener) {
        this.onStudentUpdateListener = onStudentUpdateListener;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        getReferences(view);
        setupUI();
        addListener();

        return view;
    }

    public static DetailFragment create(Student student, int operation) {
        //1: create
        DetailFragment detailFragment = new DetailFragment();
        //2: (optional) pass arg
        detailFragment.setStudent(student);
        detailFragment.setOperation(operation);

        return detailFragment;
    }

    private void addListener() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation == Student.OP_UPDATE) {
                    student.setName(tvName.getText().toString());
                    student.setGender(tvGender.getText().toString());
                    student.setAge(Integer.parseInt(tvAge.getText().toString()));

                    if (onStudentUpdateListener != null) {
                        onStudentUpdateListener.onUpdate();
                    }
                } else if (operation == Student.OP_ADD) {
                    Student student = new Student();
                    student.setName(tvName.getText().toString());
                    student.setGender(tvGender.getText().toString());
                    student.setAge(Integer.parseInt(tvAge.getText().toString()));
                    Student.list.add(student);
                    if (onStudentUpdateListener != null) {
                        onStudentUpdateListener.onUpdate();
                    }
                }
            }
        });
    }

    private void setupUI() {
        if (operation == Student.OP_UPDATE) {
            tvName.setText(student.getName());
            tvGender.setText(student.getGender());
            tvAge.setText(String.format("%s", student.getAge()));
        }
    }

    private void getReferences(View view) {
        tvName = (EditText) view.findViewById(R.id.tv_name);
        tvGender = (EditText) view.findViewById(R.id.tv_gender);
        tvAge = (EditText) view.findViewById(R.id.tv_age);
        btnSave = (Button) view.findViewById(R.id.btn_save);
    }

}
