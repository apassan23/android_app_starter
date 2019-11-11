package com.example.dynamicinterfacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        RelativeLayout layout = new RelativeLayout(this);


        //username input
        EditText username = new EditText(this);
        username.setId(2);

        RelativeLayout.LayoutParams btnConfig = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams usernameConfig = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        btnConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnConfig.addRule(RelativeLayout.CENTER_VERTICAL);

        // Button
        Button redButton = new Button(this);
        redButton.setId(1);
        redButton.setBackgroundColor(Color.RED);
        redButton.setText("Log In");

        usernameConfig.addRule(RelativeLayout.ABOVE,redButton.getId());
        usernameConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameConfig.setMargins(0,0,0,50);

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());

        username.setWidth(px);

        // Add the widget(button) to the layout
        layout.addView(redButton,btnConfig);
        layout.addView(username,usernameConfig);
        // Setting the content to this view
        setContentView(layout);
    }
}
