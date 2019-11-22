package com.example.q12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyDBHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new MyDBHandler(this,null,null,1);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText rollno = (EditText) findViewById(R.id.rollno);
        final EditText marks = (EditText) findViewById(R.id.marks);
        Button addButton = (Button) findViewById(R.id.addButton);
        Button displayButton = (Button) findViewById(R.id.displayButton);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button updateButton = (Button) findViewById(R.id.updateButton);
        final TextView text = (TextView) findViewById(R.id.display_field);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setMarks(Integer.parseInt(marks.getText().toString()));
                student.setName(name.getText().toString());
                student.setRollno(Integer.parseInt(rollno.getText().toString()));
                handler.addStudent(student);
                Toast.makeText(MainActivity.this,"Added",Toast.LENGTH_LONG).show();
            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(handler.databaseToString());
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setMarks(Integer.parseInt(marks.getText().toString()));
                student.setName(name.getText().toString());
                student.setRollno(Integer.parseInt(rollno.getText().toString()));
                handler.updateStudent(student);
                Toast.makeText(MainActivity.this,"Updated",Toast.LENGTH_LONG).show();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.deleteStudent(Integer.parseInt(rollno.getText().toString()));
                Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
