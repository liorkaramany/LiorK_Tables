package com.example.user.liork_tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class HelperDB extends SQLiteOpenHelper {

    String strCreate, strDelete;

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="students.db";

    public HelperDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        strCreate="CREATE TABLE "+Students.TABLE_STUDENTS+" (";
        strCreate+=Students.KEY_ID+" INTEGER PRIMARY KEY, ";
        strCreate+=Students.NAME+" TEXT, ";
        strCreate+=Students.ADDRESS+" TEXT, ";
        strCreate+=Students.CLASS+" TEXT, ";
        strCreate+=Students.PHONE+" TEXT );";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+Grades.TABLE_GRADES+" (";
        strCreate+=Grades.KEY_ID+" INTEGER PRIMARY KEY, ";
        strCreate+=Grades.NAME+" TEXT, ";
        strCreate+=Grades.FIRST+" INTEGER, ";
        strCreate+=Grades.SECOND+" INTEGER, ";
        strCreate+=Grades.THIRD+" INTEGER );";
        strCreate+=Grades.FOURTH+" INTEGER );";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        strDelete="DROP TABLE IF EXISTS "+Students.TABLE_STUDENTS;
        db.execSQL(strDelete);

        strDelete="DROP TABLE IF EXISTS "+Grades.TABLE_GRADES;
        db.execSQL(strDelete);

        onCreate(db);

    }
}
