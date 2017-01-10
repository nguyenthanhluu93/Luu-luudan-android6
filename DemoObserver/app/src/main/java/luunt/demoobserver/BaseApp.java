package luunt.demoobserver;

import android.app.Application;

public class BaseApp extends Application {
    Test mTest;

    @Override
    public void onCreate() {
        super.onCreate();

        mTest = new Test();
    }

    public Test getObserver() {
        return mTest;
    }

}

