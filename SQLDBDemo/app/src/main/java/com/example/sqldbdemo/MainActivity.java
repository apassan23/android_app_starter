package com.example.sqldbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button addBtn;
    private Button deleteBtn;
    private TextView text;
    private MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        addBtn = (Button) findViewById(R.id.addBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        text = (TextView) findViewById(R.id.textView);
        dbHandler = new MyDBHandler(this,null,null,1);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Products product = new Products(input.getText().toString());
                dbHandler.addProduct(product);
                printDatabase();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteProduct(input.getText().toString());
                printDatabase();
            }
        });

    }

    public void printDatabase(){
        String dbResult = dbHandler.databaseToString();
        text.setText(dbResult);
        input.setText("");
    }

}
