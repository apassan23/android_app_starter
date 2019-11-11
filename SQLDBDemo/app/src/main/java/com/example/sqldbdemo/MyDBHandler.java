package com.example.sqldbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db";
    private static final String TABLE_NAME = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "productName";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_PRODUCTNAME + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void addProduct(Products product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME,product.get_productName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
    }

    public String databaseToString(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String dbString = "";
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCTNAME));
            if(result != null){
                dbString += result + "\n";
            }
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return dbString;
    }
}
