package com.yapd.alexander.yapd.client.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by alexander on 9/21/16.
 */
public class Yapd extends Application {
    private static Context sContext;

    public static Context getContext() {
        return Yapd.sContext;
    }

    public static Resources getStaticResources() {
        return sContext.getResources();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Yapd.sContext = getApplicationContext();
    }
}
