package com.masterandroid.glbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Context context;

    //constructor
    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException{
            databaseHelper=new DatabaseHelper(context);
            database=databaseHelper.getWritableDatabase();
            return this;
    }
    public void close(){

        databaseHelper.close();
    }

    public void insert(String name){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.Subject,name);

        database.insert(DatabaseHelper.TableName,null,contentValues);
    }
    public Cursor fetch(){
        String[] columns=new String[] {DatabaseHelper._ID, DatabaseHelper.Subject};
        Cursor cursor=database.query(DatabaseHelper.TableName,columns,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();

        }
        return  cursor;
    }
    public int update (long _id,String name){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.Subject,name);


        int i=database.update(DatabaseHelper.TableName,contentValues, DatabaseHelper._ID+ " = " + _id,null);
        return i;
    }
    public void delete(long _id){
        database.delete(DatabaseHelper.TableName, DatabaseHelper._ID+" = "+_id,null);
    }


}
