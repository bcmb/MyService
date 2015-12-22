package com.example.olauta.myservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    private static final String LOG_TAG = "logger";

    @Override
    public void onCreate() {
        Log.d(LOG_TAG, "Service onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "Service onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d(LOG_TAG, "Service onStartCommand");
        Log.d(LOG_TAG, "ID" + startId);
        new Thread(new Runnable() {
            @Override
            public void run() {
                doLongRunningOperatiorn();
                stopSelf(startId);
                Log.d(LOG_TAG, "thread " + startId + " stopped");
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    public void doLongRunningOperatiorn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
