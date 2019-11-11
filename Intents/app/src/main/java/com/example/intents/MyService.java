package com.example.intents;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG = "serviceMessage";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                  long futureTime = System.currentTimeMillis() + 5000;
                  while (System.currentTimeMillis() < futureTime){
                      synchronized (this){
                          try{
                              wait(futureTime - System.currentTimeMillis());
                              Log.i(TAG,"Service is doing some important work!");
                          }catch (Exception e){
                              // Exception Handling
                          }
                      }
                  }
            }
        };

        Thread myThread = new Thread(r);
        myThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
