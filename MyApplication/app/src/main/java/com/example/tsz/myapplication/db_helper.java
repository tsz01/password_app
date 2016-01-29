package com.example.tsz.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;



public class db_helper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pw.db";
    public static final String TABLE_NAME = "password_table";
    public static final String COL_1 = "_id";
    public static final String COL_2 = "WEBPAGE";
    public static final String COL_3 = "USER";
    public static final String COL_4 = "PASSWORD";
    public static final String COL_5 = "OTHER_INFO";

    public db_helper(Context context) {


        super(context, DATABASE_NAME, null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,WEBPAGE TEXT,USER TEXT,PASSWORD TEXT,OTHER_INFO TEXT)");
        db.execSQL("CREATE TABLE login_table (_id INTEGER PRIMARY KEY AUTOINCREMENT, PW TEXT)");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXSISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXSISTS login_table");
        onCreate(db);


    }

    public boolean insert(String WEBPAGE, String USER, String PASSWORD, String OTHER_INFO) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, WEBPAGE);
        contentValues.put(COL_3, USER);
        contentValues.put(COL_4, PASSWORD);
        contentValues.put(COL_5, OTHER_INFO);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;

        } else {
            return true;

        }


    }

    public void del() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE password_table");


    }


    public Cursor select_all_data() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return cur;


    }

    public Cursor select_all_data_login_table() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM login_table", null);

        return cur;


    }

    public Integer delete(String id) {


        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "_id=?", new String[]{id});

    }

}