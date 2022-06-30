package com.masterandroid.glbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
       final Users users=new Users(SplashActivity.this);
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(users.getName()!=""){
                    Intent intent1=new Intent(getApplicationContext(),GridMainActivity.class);

                    Loginmainactivity.name.putString("username",users.getName());

                    startActivity(intent1);
                    finish();
                }
                else{
                    Intent i=new Intent(getApplicationContext(),Loginmainactivity.class);
                    startActivity(i);
                    finish();

                }



            }
        },1);
    }
}