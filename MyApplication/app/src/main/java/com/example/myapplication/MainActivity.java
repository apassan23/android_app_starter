package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "importantMessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"OnCreate Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"OnStop Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"OnDestroy Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume Called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstantState Called");
    }
}
