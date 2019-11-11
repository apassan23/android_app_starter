package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this,MyIntentService.class);
//        startService(intent);

        Intent intent = new Intent(this,MyService.class);
        startService(intent);

        final EditText input = (EditText) findViewById(R.id.input);

        Button btnToAct2 = (Button) findViewById(R.id.act1_button);
        btnToAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Activity2.class);

                intent.putExtra("message",input.getText().toString());

                startActivity(intent);
            }
        });


    }
}
