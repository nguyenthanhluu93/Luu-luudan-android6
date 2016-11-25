package com.gvn.pets.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.gvn.pets.BuildConfig;
import com.gvn.pets.R;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.base.view.root.BaseActivityDefaultCallBack;
import com.gvn.pets.ui.fragment.TestFragment;
import com.gvn.pets.utils.LogUtil;
import com.nankai.designlayout.dialog.DialogMaterial;

import io.fabric.sdk.android.Fabric;
import retrofit2.Response;

public class MainActivity extends BaseActivityDefaultCallBack implements View.OnClickListener {
    static {
        System.loadLibrary("native-lib");
    }

    private String TAG = getClass().getSimpleName();

    Button showDialog, showFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.reportCrashlytics) {
            Fabric.with(this, new Crashlytics());
        }

        setContentView(R.layout.activity_main);

        showDialog = bindView(R.id.show_dialog);
        showFragment = bindView(R.id.show_fragment);
        showDialog.setOnClickListener(this);
        showFragment.setOnClickListener(this);

        //Sample get buildTypes
        LogUtil.i(TAG, getString(R.string.version_name));
        LogUtil.i(TAG, getString(R.string.app_name));
        LogUtil.i(TAG, BuildConfig.SERVER_URL);
    }

    public native String stringFromJNI();

    @Override
    public <E extends ServerResponse> void showContent(Response<E> response) {
        //TODO
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_dialog:
                final DialogMaterial.Builder dialogHeader = new DialogMaterial.Builder(this)
                        .setIcon(R.mipmap.ic_launcher)
                        .withDialogAnimation(true)
                        .setTitle("Awesome!")
                        .setDescription(stringFromJNI())
                        .setHeaderColor(R.color.colorAccent)
                        .onPositive("DialogMaterial", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO
                            }
                        });
                dialogHeader.show();
                break;
            case R.id.show_fragment:
                loadRootFragment(R.id.content, TestFragment.newInstance(1));
                break;
        }
    }
}
