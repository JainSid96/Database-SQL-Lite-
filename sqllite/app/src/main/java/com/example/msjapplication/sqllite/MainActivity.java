package com.example.msjapplication.sqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("User" , MODE_PRIVATE , null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            myDatabase.execSQL("INSERT INTO users (name , age) VALUES ('Sid' , 21)");
            myDatabase.execSQL("INSERT INTO users (name , age) VALUES ('Arpit' , 22)");
            Cursor c = myDatabase.rawQuery("SELECT * FROM users" , null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            c.moveToFirst();

            while(c!=null){
                Log.i(" name " ,c.getString(nameIndex));
                Log.i(" age " ,c.getString(ageIndex));
                c.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

/*
        try{
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Events" , MODE_PRIVATE , null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS event (name VARCHAR, year INT(4))");
            myDatabase.execSQL("INSERT INTO event (name , year) VALUES ('WW1' , 1781)");
            myDatabase.execSQL("INSERT INTO event (name , year) VALUES ('WW2' , 1828)");
            Cursor c = myDatabase.rawQuery("SELECT * FROM event" , null);

            int nameIndex = c.getColumnIndex("name");
            int yearIndex = c.getColumnIndex("year");
            c.moveToFirst();

            while(c!=null){
                Log.i(" name " ,c.getString(nameIndex));
                Log.i(" year " ,c.getString(yearIndex));
                c.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        */
    }
}
