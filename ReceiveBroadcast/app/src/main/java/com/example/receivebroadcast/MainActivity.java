package com.example.receivebroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyReceiver receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.sendbroadcast");
        this.registerReceiver(receiver,filter);
    }
}
