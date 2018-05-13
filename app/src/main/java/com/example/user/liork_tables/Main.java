package com.example.user.liork_tables;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDB hlp;
    EditText[] et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=new EditText[8];
        et[0]=(EditText) findViewById(R.id.name);
        et[1]=(EditText) findViewById(R.id.address);
        et[2]=(EditText) findViewById(R.id.classs);
        et[3]=(EditText) findViewById(R.id.phone);
        et[4]=(EditText) findViewById(R.id.first);
        et[5]=(EditText) findViewById(R.id.second);
        et[6]=(EditText) findViewById(R.id.third);
        et[7]=(EditText) findViewById(R.id.fourth);

        hlp=new HelperDB(this);
    }

    public void add(View view) {
        boolean allFilled=true;
        int i=0;
        while (i<et.length && allFilled)
        {
            if (et[i].getText().toString().isEmpty())
                allFilled=false;
            i++;
        }
        if (!allFilled)
        {
            Toast.makeText(this, "You haven't entered all the information.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ContentValues cv=new ContentValues();

            cv.put(Students.NAME, et[0].getText().toString());
            cv.put(Students.ADDRESS, et[1].getText().toString());
            cv.put(Students.CLASS, et[2].getText().toString());
            cv.put(Students.PHONE, et[3].getText().toString());

            db=hlp.getWritableDatabase();
            db.insert(Students.TABLE_STUDENTS, null, cv);

            cv=new ContentValues();

            cv.put(Grades.NAME, et[0].getText().toString());
            cv.put(Grades.FIRST, et[4].getText().toString());
            cv.put(Grades.SECOND, et[5].getText().toString());
            cv.put(Grades.THIRD, et[6].getText().toString());
            cv.put(Grades.FOURTH, et[7].getText().toString());

            db.insert(Grades.TABLE_GRADES, null, cv);

            db.close();

            Toast.makeText(this, "Your have successfully added the information.", Toast.LENGTH_SHORT).show();
        }
    }

    public void next(View view) {
        Intent t=new Intent(this, Table.class);
        startActivity(t);
    }
}
