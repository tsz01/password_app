package com.example.tsz.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

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

    }

}