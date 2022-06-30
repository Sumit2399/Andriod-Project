package com.masterandroid.glbapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Users {
    Context context;
    private String name;

    public void removeUser(){
        sharedPreferences.edit().clear().commit();
    }

    public String getName() {
        name=sharedPreferences.getString("userdata","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        sharedPreferences.edit().putString("userdata",name).commit();
    }

    SharedPreferences sharedPreferences;
    public Users(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);

    }
}
