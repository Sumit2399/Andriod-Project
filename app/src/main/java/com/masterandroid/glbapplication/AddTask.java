package com.masterandroid.glbapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddTask extends Activity implements View.OnClickListener {
    private EditText subedit;
    private EditText subedit1;
    private EditText subedit2;
    private EditText subedit3;
    TextView tt;
    private Button button,button1,button2;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");
        setContentView(R.layout.activity_add_country1);

         subedit1= (EditText)findViewById(R.id.editTextNumber2);
        subedit2=(EditText)findViewById(R.id.editTextNumber3);
        subedit3=(EditText)findViewById(R.id.editTextNumber4);
       // tt=(TextView)findViewById(R.id.textView15);
        subedit=(EditText) findViewById(R.id.subject_edittext);
        String str1=subedit1.getText().toString();
        String str2=subedit2.getText().toString();
        String str3=subedit3.getText().toString();

        button=(Button)findViewById(R.id.addtask);
        button1=(Button)findViewById(R.id.back1);
        dbManager=new DBManager(this);
        dbManager.open();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),TodoList.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addtask:
               // final String name=subedit.getText().toString();
                double num1=Double.parseDouble(subedit1.getText().toString());
                double num2=Double.parseDouble(subedit2.getText().toString());
                double num3=Double.parseDouble(subedit2.getText().toString());
                double sum=num1+num2+num3;
                Calendar calendar;
                String dateTime;
                SimpleDateFormat simpleDateFormat;
                calendar = Calendar.getInstance();
                simpleDateFormat = new SimpleDateFormat("dd.LLLL.yyyy ");
                dateTime = simpleDateFormat.format(calendar.getTime()).toString();
                dbManager.insert(Double.toString(sum)+" calories "+dateTime);
                Intent i=new Intent(AddTask.this, TodoList.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
        }
    }
}