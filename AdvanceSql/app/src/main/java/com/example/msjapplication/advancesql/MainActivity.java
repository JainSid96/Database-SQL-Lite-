package com.example.msjapplication.advancesql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase People = this.openOrCreateDatabase("People" , MODE_PRIVATE , null);

            People.execSQL("CREATE TABLE IF NOT EXISTS newPpl (name VARCHAR , age INTEGER(3) , id INTEGER PRIMARY KEY)");

            People.execSQL("INSERT INTO newPpl (name , age) VALUES ('Sid' , 21)");
            People.execSQL("INSERT INTO newPpl (name , age) VALUES ('Arpit' , 22)");
            People.execSQL("INSERT INTO newPpl (name , age) VALUES ('Gera' , 15)");

           // myDatabase.execSQL("CREATE TABLE IF NOT EXISTS ppl (name VARCHAR, age INT(3))");

           // myDatabase.execSQL("INSERT INTO ppl (name , age) VALUES ('Sid' , 21)");
           // myDatabase.execSQL("INSERT INTO ppl (name , age) VALUES ('Arpit' , 22)");
           // myDatabase.execSQL("INSERT INTO ppl (name , age) VALUES ('Gera' , 15)");
            //myDatabase.execSQL("INSERT INTO ppl (name , age) VALUES ('Anmol' , 17)");
           // myDatabase.execSQL("DELETE FROM ppl WHERE name = 'Gera'");
           // myDatabase.execSQL("UPDATE ppl SET age = 2 WHERE name = 'Gera'");

            Cursor c = People.rawQuery("SELECT * FROM newPpl "  , null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            while(c!=null){
                Log.i(" name " ,c.getString(nameIndex));
                Log.i(" age " ,Integer.toString(c.getInt(ageIndex)));
                Log.i(" id " ,Integer.toString(c.getInt(idIndex)));
                c.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
