package com.masterandroid.glbapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class GridMainActivity extends AppCompatActivity {
    CardView todo,time,down,about;
    String str=Loginmainactivity.name.getString("username");
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewactivity_main);
        todo=findViewById(R.id.todol);
        time=findViewById(R.id.timet);
        down=findViewById(R.id.downl);
        about=findViewById(R.id.abou);
        tv=findViewById(R.id.textv);
        tv.setText("Hello,"+str);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GridMainActivity.this, TodoList.class);
                startActivity(i);

            }
        });
       time.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(GridMainActivity.this, bmi.class);
               startActivity(i);
           }
       });
       down.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(GridMainActivity.this, DownLoad.class);
               startActivity(i);

           }
       });
       about.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(GridMainActivity.this, About.class);
               startActivity(i);

           }
       });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(GridMainActivity.this);
        builder.setTitle("").
                setMessage("You sure, that you want to exit?");
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    public void onClick(DialogInterface dialog, int id) {

                        finishAffinity();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder.create();
        alert11.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_logout){
            AlertDialog.Builder builder = new AlertDialog.Builder(GridMainActivity.this);
            builder.setTitle("").
                    setMessage("You sure, that you want to logout?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        public void onClick(DialogInterface dialog, int id) {
                            new Users(GridMainActivity.this).removeUser();
                            Intent i = new Intent(getApplicationContext(),
                                    Loginmainactivity.class);

                            finishAffinity();
                            startActivity(i);
                            android.os.Process.killProcess(android.os.Process.myPid());

                        }
                    });
            builder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder.create();
            alert11.show();

        }

        return super.onOptionsItemSelected(item);

    }
}