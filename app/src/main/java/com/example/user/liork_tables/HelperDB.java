package com.example.user.liork_tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class HelperDB extends SQLiteOpenHelper implements BaseColumns {

    public static final int DATABASE_VERSION=1;
    public static final String DB_NAME="students.db";

    private int _id;
    public static final String TABLE_USERS="Students";
    private static final String KEY_ID="_id";
    public static final String LOGIN="Login";
    public static final String NAME="Name";
    public static final String LGROUP="Lgroup";
    public static final String PHONE="Phone";


    public HelperDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    public HelperDB(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String strCreate="CREATE TABLE "+TABLE_USERS;
        strCreate+="("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        strCreate+=LOGIN+" TEXT, ";
        strCreate+=NAME+" TEXT, ";
        strCreate+=LGROUP+" TEXT,";
        strCreate+=PHONE+" TEXT";
        strCreate+=");";

        db.execSQL(strCreate);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String strDelete="DROP TABLE IF EXISTS "+TABLE_USERS;
        db.execSQL(strDelete);
    }
}
