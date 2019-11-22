package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        TextView[] textArray = new TextView[30];

        for(int i = 0; i < 30; i++){
            textArray[i] = new TextView(context);
            textArray[i].setText("Text View Number " + (i + 1));
            textArray[i].setTextSize(30);
            layout.addView(textArray[i]);
        }
    }
}
