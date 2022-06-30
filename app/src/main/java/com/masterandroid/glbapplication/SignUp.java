package com.masterandroid.glbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText username1,password1,repassword1;
    Button button,back;
    DbHelper1 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

       username1=(EditText)findViewById(R.id.user);
       password1=(EditText)findViewById(R.id.password);
       repassword1=(EditText)findViewById(R.id.repassword);
       back=(Button)findViewById(R.id.back);
       button=findViewById(R.id.register);
       db=new DbHelper1(this);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String user=username1.getText().toString();
               String pass=password1.getText().toString();
               String repass=repassword1.getText().toString();

               if(user.equals("")||pass.equals("")||repass.equals(""))
                   Toast.makeText(SignUp.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
               else{
                   if(pass.equals(repass)){
                       Boolean checkuser=db.checkUsername(user);
                       if(checkuser==false){
                           Boolean insert=db.insertData(user,pass);
                           if(insert==true){
                               Toast.makeText(SignUp.this,"Registered Succesfully",Toast.LENGTH_SHORT).show();
                               Intent intent=new Intent(getApplicationContext(),Loginmainactivity.class);
                               startActivity(intent);
                           }
                           else{
                               Toast.makeText(SignUp.this,"Registration failed",Toast.LENGTH_SHORT).show();
                           }
                       }
                       else{
                           Toast.makeText(SignUp.this,"User already exist!Please sign in",Toast.LENGTH_SHORT).show();
                       }
                   }
                   else{
                       Toast.makeText(SignUp.this,"Password Not Matching",Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),Loginmainactivity.class);
        startActivity(i);
    }
});


    }
}