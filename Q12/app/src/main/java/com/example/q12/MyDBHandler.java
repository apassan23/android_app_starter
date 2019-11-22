package com.example.q12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ROLLNO = "rollno";
    private static final String COLUMN_MARKS = "marks";
    private static final String TABLE_NAME = "student";


    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_NAME + " text," +
                COLUMN_ROLLNO + " int PRIMARY KEY," +
                COLUMN_MARKS + " int" +
                ");";
        db.execSQL(query);
    }

    public void addStudent(Student student){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,student.getName());
        contentValues.put(COLUMN_ROLLNO,student.getRollno());
        contentValues.put(COLUMN_MARKS,student.getMarks());
        db.insert(TABLE_NAME,null,contentValues);
    }

    public String databaseToString(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        String dbString = "";
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            dbString += cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) + " " +
                    cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO)) + " " +
                    cursor.getString(cursor.getColumnIndex(COLUMN_MARKS)) + "\n";
            cursor.moveToNext();
        }
        cursor.close();
        return dbString;
    }

    public void deleteStudent(int rollno){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ROLLNO + "=" + rollno + ";");
    }

    public void updateStudent(Student student){
        SQLiteDatabase db = getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_NAME + "=\'" + student.getName() + "\'," + COLUMN_MARKS + "=" + student.getMarks()+ " WHERE " + COLUMN_ROLLNO + "=" + student.getRollno() + ";";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(newVersion);
    }
}
