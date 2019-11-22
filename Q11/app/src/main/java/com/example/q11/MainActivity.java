package com.example.q11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText) findViewById(R.id.editText);
        final EditText password = (EditText) findViewById(R.id.editText2);
        Button loginButton = (Button) findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this,"All Fields should bt filled",Toast.LENGTH_LONG).show();
                else {
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    intent.putExtra("username",username.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
