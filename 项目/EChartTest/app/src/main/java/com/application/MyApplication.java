package com.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016-08-01.
 */
public class MyApplication extends Application{

    private static Context context;

    public void onCreate(){
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
