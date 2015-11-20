package com.example.christina.cocornell;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christina on 11/14/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String name = "CoCornellDatabase";
    private static final int version = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("" +
                "CREATE TABLE IF NOT EXISTS user(netid varchar(10))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
