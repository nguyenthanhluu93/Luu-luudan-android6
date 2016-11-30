package com.gvn.pets.ui.activity;

import android.os.Bundle;

import com.gvn.pets.R;
import com.gvn.pets.base.view.root.SupportActivity;

public class MainActivity extends SupportActivity {

//    static {
//        System.loadLibrary("native-lib");
//    }
//
//    private String TAG = getClass().getSimpleName();
//
//    Button showDialog, showFragment;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        showDialog = bindView(R.id.show_dialog);
//        showFragment = bindView(R.id.show_fragment);
//        showDialog.setOnClickListener(this);
//        showFragment.setOnClickListener(this);
//
//        //Sample get buildTypes
//        LogUtil.i(TAG, getString(R.string.version_name));
//        LogUtil.i(TAG, getString(R.string.app_name));
//        LogUtil.i(TAG, BuildConfig.SERVER_URL);
    }
//
//    public native String stringFromJNI();
//
//    @Override
//    public <E extends ServerResponse> void showContent(Response<E> response) {
//        //TODO
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.show_dialog:
//                final DialogMaterial.Builder dialogHeader = new DialogMaterial.Builder(this)
//                        .setIcon(R.mipmap.ic_launcher)
//                        .withDialogAnimation(true)
//                        .setTitle("Awesome!")
//                        .setDescription(stringFromJNI())
//                        .setHeaderColor(R.color.colorAccent)
//                        .onPositive("DialogMaterial", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //TODO
//                            }
//                        });
//                dialogHeader.show();
//                break;
//            case R.id.show_fragment:
//                loadRootFragment(R.id.content, TestFragment.newInstance(1));
//                break;
//        }
//    }
}
