package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] teams = {"Real Madrid","Bayern Munich","Juventus","Liverpool","Manchester City","Barcelona"};
        ListAdapter myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,teams);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(myAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String team = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,team,Toast.LENGTH_LONG).show();
            }
        });

    }
}
