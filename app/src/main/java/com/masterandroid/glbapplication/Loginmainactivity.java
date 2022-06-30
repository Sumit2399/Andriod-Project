package com.masterandroid.glbapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Loginmainactivity extends AppCompatActivity {
    EditText editText1,editText2;
    public static Bundle name=new Bundle();
    Button signin,signup;
    DbHelper1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity_main);

        editText1=findViewById(R.id.username);
        editText2=findViewById(R.id.pass);
        signin=findViewById(R.id.b1);
         signup=findViewById(R.id.b2);
         db=new DbHelper1(this);

         signin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String user=editText1.getText().toString();
           String pass=editText2.getText().toString();

           if(user.equals("")||pass.equals(""))
               Toast.makeText(Loginmainactivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
           else{
               Boolean checkuserpass=db.checkUsernamepassword(user,pass);
               if(checkuserpass==true){
                   Users users=new Users(Loginmainactivity.this);
                   users.setName(user);

                   Toast.makeText(Loginmainactivity.this,"Sign in successfull",Toast.LENGTH_SHORT).show();
                   Intent intent1=new Intent(getApplicationContext(),GridMainActivity.class);
                    Loginmainactivity.name.putString("username",user);

                   startActivity(intent1);
               }
               else{
                   Toast.makeText(Loginmainactivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
               }
           }
        }
    });
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),SignUp.class);
                    startActivity(intent);
                }
            });

    }


}