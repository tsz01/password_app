package com.example.tsz.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    db_helper db;
    db_helper db_data = new db_helper(this);
    Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);





        fill_list();
        show_details();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_new:
                add_activity();
                return true;

            case R.id.menu_refresh:
                fill_list();
                return true;
            case R.id.menu_ch_passwd:
                ch_passwd();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void fill_list(){
        list_view =(ListView)findViewById(R.id.listView2);
        Cursor cur2 = db_data.select_all_data();

        String[] from_field_names = new String[] {db_helper.COL_1,db_helper.COL_2};
        int[] view_id = new int[] {R.id.textView2,R.id.textView3};
        SimpleCursorAdapter my_cursor_adaper;
        my_cursor_adaper = new SimpleCursorAdapter(getBaseContext(),R.layout.activity_main,cur2,from_field_names, view_id,0);

        list_view.setAdapter(my_cursor_adaper);


    }


    public void show_details()
    {

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Cursor res = (Cursor) parent.getAdapter().getItem(position);
                StringBuffer buffer = new StringBuffer();
                buffer.append("ID: " + res.getString(0) + "\n");
                buffer.append("WEBPAGE: " + res.getString(1) + "\n");
                buffer.append("USERNAME: " + res.getString(2) + "\n");
                buffer.append("PASSWORD: " + res.getString(3) + "\n");
                buffer.append("OTHER_INFO: " + res.getString(4) + "\n\n");
                show_message("DETAILS", buffer.toString());


            }
        });



    }

    public void show_message(String title, String message)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }



    public void add_activity() {
        Intent intent = new Intent(MainActivity.this,add.class);
        startActivity(intent);

    }

    public void ch_passwd()
    {

        Intent intent  =new Intent(MainActivity.this,ch_passwd.class);
        startActivity(intent);

    }
}
