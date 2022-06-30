package com.masterandroid.glbapplication;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TodoList extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[]{DatabaseHelper._ID,DatabaseHelper.Subject};
    final int[] to = new int[]{R.id.id, R.id.title};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        dbManager=new DBManager(this);
        dbManager.open();

        Cursor cursor = dbManager.fetch();
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter=new SimpleCursorAdapter(this,R.layout.activity_view_record,cursor,from,to,0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // onclicklistiner for list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView idtextview = view.findViewById(R.id.id);
                TextView titletextview = view.findViewById(R.id.title);


                String id1 = idtextview.getText().toString();
                String title = titletextview.getText().toString();


                Intent modify_intent = new Intent(getApplicationContext(), ModifyTask.class);
                modify_intent.putExtra("title", title);

                modify_intent.putExtra("id", id1);

                startActivity(modify_intent);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.addtask){
            Intent add_mem=new Intent(this, AddTask.class);
            startActivity(add_mem);
        }

        return super.onOptionsItemSelected(item);

    }
}
