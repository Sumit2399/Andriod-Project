package com.masterandroid.glbapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String str=Loginmainactivity.name.getString("username");
    public static String name=str+".db";
    //TableName
    public static  String TableName="todolist";
    //COLUMN
    public static final String _ID="_id";
    public static final String Subject="subject";

    //database information
   static final String DB_Name=name;
   //database version
    static final int DB_Version= 1;
    //create table query
    private static final String Create_table=" create table " +TableName+ "("+ _ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                             Subject+ " TEXT NOT NULL);";
    //CONSTRUCTOR

        public DatabaseHelper(Context context){
                super(context,DB_Name,null,DB_Version);
        }

        @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(Create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS "+TableName);
            onCreate(db);
    }
}
