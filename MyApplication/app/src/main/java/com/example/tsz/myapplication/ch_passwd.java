package com.example.tsz.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ch_passwd extends AppCompatActivity {
    db_helper db;
    Button change_password;
    EditText current_pw;
    EditText new_pw;
    EditText new_pw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch_passwd);

        db= new db_helper(this);
        change_password = (Button)findViewById(R.id.button_change_passwd);
        current_pw =(EditText)findViewById(R.id.editText_current_passwd);
        new_pw = (EditText)findViewById(R.id.editText_new_passwd);
        new_pw2= (EditText)findViewById(R.id.editText_new_passwd_2);
        ch_pass();
    }




    public void ch_pass()
    {
        final Cursor c = db.select_all_data_login_table();

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.moveToFirst();

                if (c.getString(1).equals(current_pw.getText().toString())) {
                    if (new_pw.equals(new_pw2.getText().toString())) {

                        db.update_passwd("1", new_pw2.getText().toString());
                        Toast.makeText(ch_passwd.this, "Password Changed", Toast.LENGTH_LONG);

                    } else
                        Toast.makeText(ch_passwd.this, "Error", Toast.LENGTH_LONG);

                }
            }
        });



    }
}
