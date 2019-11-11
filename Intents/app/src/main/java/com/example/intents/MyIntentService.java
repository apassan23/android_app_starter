package com.example.intents;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    private static final String TAG = "serviceMessage";

    public MyIntentService(){
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // This is what the service does
        Log.i(TAG,"Service is Running!");
    }
}

