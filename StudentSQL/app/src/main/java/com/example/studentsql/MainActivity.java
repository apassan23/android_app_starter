package com.example.studentsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new MyDBHandler(this,null,null,1);

        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText rollno = (EditText) findViewById(R.id.editText2);
        final EditText marks = (EditText) findViewById(R.id.editText3);

        Button addButton = (Button) findViewById(R.id.addButton);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button updateButton = (Button) findViewById(R.id.updateButton);
        Button displayButton = (Button) findViewById(R.id.displayButton);
        final TextView text = (TextView) findViewById(R.id.textView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setName(name.getText().toString());
                student.setMarks(Integer.parseInt(marks.getText().toString()));
                student.setRollno(Integer.parseInt(rollno.getText().toString()));
                handler.addStudent(student);
                Toast.makeText(MainActivity.this,"Added",Toast.LENGTH_LONG).show();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.deleteStudent(Integer.parseInt(rollno.getText().toString()));
                Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_LONG).show();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setName(name.getText().toString());
                student.setMarks(Integer.parseInt(marks.getText().toString()));
                student.setRollno(Integer.parseInt(rollno.getText().toString()));
                handler.updateStudent(student);
                Toast.makeText(MainActivity.this,"Updated",Toast.LENGTH_LONG).show();
            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(handler.databaseToString());
            }
        });

    }
}
