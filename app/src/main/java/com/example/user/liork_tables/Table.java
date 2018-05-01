package com.example.user.liork_tables;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Table extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDB hlp;

    ListView lv1;
    ArrayAdapter adp1;
    ArrayList<String> tbl1;

    ListView lv2;
    ArrayAdapter adp2;
    ArrayList<String> tbl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        lv1=(ListView) findViewById(R.id.lv1);
        lv2=(ListView) findViewById(R.id.lv2);

        tbl1=new ArrayList<>();
        tbl2=new ArrayList<>();

        hlp=new HelperDB(this);
        db=hlp.getWritableDatabase();

        Cursor c=db.query(Students.TABLE_STUDENTS, null, null, null, null, null, null);

        int col1=c.getColumnIndex(Students.KEY_ID);
        int col2=c.getColumnIndex(Students.NAME);
        int col3=c.getColumnIndex(Students.ADDRESS);
        int col4=c.getColumnIndex(Students.CLASS);
        int col5=c.getColumnIndex(Students.PHONE);

        c.moveToFirst();

        String name, address, classs, phone;

        while (!c.isAfterLast())
        {
            name=c.getString(col2);
            address=c.getString(col3);
            classs=c.getString(col4);
            phone=c.getString(col5);

            String tmp=name+","+address+","+classs+","+address+","+phone;
            tbl1.add(tmp);

            c.moveToNext();
        }
        c.close();

        adp1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tbl1);
        lv1.setAdapter(adp1);



        c=db.query(Grades.TABLE_GRADES, null, null, null, null, null, null);

        int col6=c.getColumnIndex(Grades.KEY_ID);
        int col7=c.getColumnIndex(Grades.NAME);
        int col8=c.getColumnIndex(Grades.FIRST);
        int col9=c.getColumnIndex(Grades.SECOND);
        int col10=c.getColumnIndex(Grades.THIRD);
        int col11=c.getColumnIndex(Grades.FOURTH);

        c.moveToFirst();

        String first, second, third, fourth;

        while (!c.isAfterLast())
        {
            first=c.getString(col8);
            second=c.getString(col9);
            third=c.getString(col10);
            fourth=c.getString(col11);

            String tmp=first+","+second+","+third+","+fourth;
            tbl2.add(tmp);

            c.moveToNext();
        }
        c.close();

        adp2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tbl2);
        lv2.setAdapter(adp2);

        db.close();
    }

    public void sort(View view) {
    }

    public void filter(View view) {
    }

    public void delete(View view) {
    }

    public void add(View view) {
        Intent t=new Intent(this, Main.class);
        startActivity(t);
    }
}
