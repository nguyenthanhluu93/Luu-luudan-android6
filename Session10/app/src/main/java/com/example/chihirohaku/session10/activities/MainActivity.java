package com.example.chihirohaku.session10.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.chihirohaku.session10.R;
import com.example.chihirohaku.session10.dialogfragments.LoginDialogFragment;
import com.thin.downloadmanager.DefaultRetryPolicy;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListenerV1;
import com.thin.downloadmanager.ThinDownloadManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.btn_dialog)
    Button openDialog;
    @BindView(R.id.btn_progress_dialog)
    Button testProgressDialog;
    @BindView(R.id.btn_test_custom_dialog)
    Button btnTestCustomDialog;
    @BindView(R.id.btn_test_snackbar)
    Button btnTestSnackBar;
    @BindView(R.id.ll_root)
    View llRoot;

    ThinDownloadManager downloadManager;
    final String DOWNLOAD_URL = "https://edmullen.net/test/rc.jpg";

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        downloadManager = new ThinDownloadManager();
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

    }

    @OnClick(R.id.btn_dialog)
    public void openDialog(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Quesion");
        alertDialog.setMessage("Do you want eat shit?");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.show();
    }

    @OnClick(R.id.btn_progress_dialog)
    public void testProgressDialog(View view) {
        Uri srcUri = Uri.parse(DOWNLOAD_URL);
        Uri desUri = Uri.parse(this.getFilesDir() + "/image.jpg");
        DownloadRequest downloadRequest = new DownloadRequest(srcUri)
                .setRetryPolicy(new DefaultRetryPolicy())
                .setDestinationURI(desUri)
                .setStatusListener(new DownloadStatusListenerV1() {
                    @Override
                    public void onDownloadComplete(DownloadRequest downloadRequest) {
                        Log.d(TAG, "onDownloadComplete");
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onDownloadFailed(DownloadRequest downloadRequest, int errorCode, String errorMessage) {
                        Log.d(TAG, "onDownloadFailed");
                    }

                    @Override
                    public void onProgress(DownloadRequest downloadRequest, long totalBytes, long downloadedBytes, int progress) {
                        Log.d(TAG, "onProgress");
                        progressDialog.setProgress(progress);
                    }
                });
        progressDialog.show();
        downloadManager.add(downloadRequest);
    }

    @OnClick(R.id.btn_test_custom_dialog)
    public void testCustomDialog(View v) {
        // create dialog fragment
        LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
        loginDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);  // android 6.0 tro len

        //show
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        loginDialogFragment.show(fragmentManager, null);
    }

    @OnClick(R.id.btn_test_snackbar)
    public void testSnackBar(View v) {
        Snackbar snackbar = Snackbar.make(llRoot, "Hi, this is a snack bar", Snackbar.LENGTH_SHORT);

        snackbar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_account, menu);
//        // bat su kien: cach 1
//        menu.findItem(R.id.it_remove)
//        .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                return false;
//            }
//        });
        return true;
    }

    // bat su kien: cach 2
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it_remove:
                Log.d(TAG, "Remove item selected");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}