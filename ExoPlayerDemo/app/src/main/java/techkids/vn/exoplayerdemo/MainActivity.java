package techkids.vn.exoplayerdemo;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.thin.downloadmanager.DefaultRetryPolicy;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListenerV1;
import com.thin.downloadmanager.ThinDownloadManager;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hybridmediaplayer.Hybrid;

public class MainActivity extends AppCompatActivity implements Hybrid.OnCompletionListener, Hybrid.OnErrorListener, Hybrid.OnPreparedListener {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.bt_test)
    Button btTest;


    Hybrid hybrid;

    private ThinDownloadManager downloadManager;

    Handler mainHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainHandler = new Handler();

        hybrid = Hybrid.getInstance(this);
        downloadManager = new ThinDownloadManager();


        setup();
    }

    private void setup() {

    }

    @OnClick(R.id.bt_test)
    void test() {
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        hybrid.setDataSource("http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVEDLVAGTVDGTDGLG");
//        hybrid.setOnCompletionListener(this);
//        hybrid.setOnErrorListener(this);
//        hybrid.setOnPreparedListener(this);
        hybrid.prepare();
        hybrid.play();
    }

    @OnClick(R.id.bt_test_with_offline_data)
    void testOffline() {

        Toast.makeText(MainActivity.this, "Start download", Toast.LENGTH_SHORT).show();

        Uri downloadUri = Uri.parse("http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVEDLVAGTVDGTDGLG");
        final String offlineUrl = this.getFilesDir().toString()+"/test.mp3";
        Uri destinationUri = Uri.parse(offlineUrl);
        DownloadRequest downloadRequest = new DownloadRequest(downloadUri)
                .setRetryPolicy(new DefaultRetryPolicy())
                .setDestinationURI(destinationUri).setPriority(DownloadRequest.Priority.HIGH)
                .setStatusListener(new DownloadStatusListenerV1() {
                    @Override
                    public void onDownloadComplete(DownloadRequest downloadRequest) {
                        Toast.makeText(MainActivity.this, "Download complete", Toast.LENGTH_SHORT).show();
                        hybrid.setDataSource(offlineUrl);
//        hybrid.setOnCompletionListener(this);
//        hybrid.setOnErrorListener(this);
//        hybrid.setOnPreparedListener(this);
                        hybrid.prepare();
                        hybrid.play();
                    }

                    @Override
                    public void onDownloadFailed(DownloadRequest downloadRequest, int errorCode, String errorMessage) {
                        Toast.makeText(MainActivity.this, String.format("onDownloadFailed : %s", errorMessage), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onProgress(DownloadRequest downloadRequest, long totalBytes, long downloadedBytes, int progress) {
                        Log.d(TAG, "onProgress");
                    }
                });

        downloadManager.add(downloadRequest);
    }

    @Override
    public void onCompletion(Hybrid hybrid) {
        Log.d(TAG, "onCompletion");
    }

    @Override
    public void onError(Hybrid hybrid) {
        Log.d(TAG, "onError");
    }

    @Override
    public void onPrepared(Hybrid hybrid) {
        Log.d(TAG, "onPrepared");
    }
}
