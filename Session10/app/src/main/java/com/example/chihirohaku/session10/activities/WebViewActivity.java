package com.example.chihirohaku.session10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.chihirohaku.session10.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.wv_toidicodedao)
    WebView wvToiDiCodeDao;
    final String TOI_DI_CODE_DAO = "http://jakewharton.github.io/butterknife/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        ButterKnife.bind(this);

        wvToiDiCodeDao.setWebViewClient(new WebViewClient());  // 1 so TH ko hien ra noi dung webview thi dung cai nay =))))))

        loadWebPage();

    }

    private void loadWebPage() {
        wvToiDiCodeDao.loadUrl(TOI_DI_CODE_DAO);
    }
}
