package com.luunt.ondrawdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import at.grabner.circleprogress.CircleProgressView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cvp_download)
    CircleProgressView cpvDownload;

    @BindView(R.id.btn_change)
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_change)
    public void onButtonChange(View v) {
        cpvDownload.setValueAnimated(cpvDownload.getCurrentValue() + 5);
    }
}
