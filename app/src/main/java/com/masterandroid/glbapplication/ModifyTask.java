package com.masterandroid.glbapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyTask extends Activity implements View.OnClickListener {

    private EditText subedit;

    private Button update;
    private Button delete;
    private DBManager dbManager;
    private long _id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_country);
        dbManager=new DBManager(this);
        dbManager.open();

        subedit=(EditText)findViewById(R.id.subject_edittext);
       // descedit=(EditText)findViewById(R.id.description_edittext);
        update=(Button)findViewById(R.id.button_update);
        delete=(Button)findViewById(R.id.button_delete);


        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        String name=intent.getStringExtra("name");
       // String desc=intent.getStringExtra("desc");

        _id=Long.parseLong(id);

        subedit.setText(name);
       // descedit.setText(desc);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.button_update:
                String title=subedit.getText().toString();
               // String desc=descedit.getText().toString();
                dbManager.update(_id,title);
                this.returnHome();
                break;

            case R.id.button_delete:
                dbManager.delete(_id);
                this.returnHome();
                break;
        }

    }

    private void returnHome() {
        Intent home_intent=new Intent(getApplicationContext(), TodoList.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}