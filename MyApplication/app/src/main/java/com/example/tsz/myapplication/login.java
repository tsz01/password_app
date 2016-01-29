package com.example.tsz.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    db_helper db;
    EditText password;
    Button login;

    Button button_create_pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new db_helper(this);
        setContentView(R.layout.activity_login);
        password = (EditText) findViewById(R.id.editText);
        password.setRawInputType(Configuration.KEYBOARD_12KEY);
        password.requestFocus();


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        login = (Button) findViewById(R.id.button);
        button_create_pin = (Button) findViewById(R.id.button_create_pin);


        login_db();
    }




    public void login_db() {

        final Cursor c = db.select_all_data_login_table();

        if(c.getCount() ==0)
        {

            button_create_pin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    db.insert_login_table(password.getText().toString());
                    finish();
                    startActivity(getIntent());
                    Toast.makeText(login.this, "PIN created sucessfully", Toast.LENGTH_LONG).show();

                }
            });

        }
        else
        {

            button_create_pin.setVisibility(View.GONE);
        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Cursor c = db.select_all_data_login_table();
                c.moveToFirst();

                if(c.getString(1).equals(password.getText().toString())) {
                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.animation, R.anim.animation2);

                }

                else {


                    Toast.makeText(login.this, "Wrong Password", Toast.LENGTH_LONG).show();
                }




            }
        });




    }


}