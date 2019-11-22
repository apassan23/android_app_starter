package com.example.q7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String coach = "";
                if(checkedId == R.id.real_madrid) coach = "Zinedine Zidane";
                else if(checkedId == R.id.barcelona) coach = "Ernesto Valverde";
                else if(checkedId == R.id.liverpool) coach = "Jurgen Klop";

                Toast.makeText(MainActivity.this,coach,Toast.LENGTH_LONG).show();
            }
        });
    }
}
