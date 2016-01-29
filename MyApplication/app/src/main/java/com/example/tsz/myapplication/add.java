package com.example.tsz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity {
    db_helper db;
    EditText webpage,user,password,other_info;

    Button add_new;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add);

        db = new db_helper(this);

        webpage = (EditText)findViewById(R.id.editText_webpage);
        user=(EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        other_info = (EditText)findViewById(R.id.editText_other_info);
        add_new=(Button)findViewById(R.id.button_new);

        add_new();

    }


    public void add_new(){



        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean is_inserted = db.insert(webpage.getText().toString(), user.getText().toString(), password.getText().toString(), other_info.getText().toString());

                if (is_inserted == true) {

                    Toast.makeText(add.this, "New data inserted sucessfully", Toast.LENGTH_LONG).show();


                } else

                    Toast.makeText(add.this, "Error", Toast.LENGTH_LONG).show();


            }
        });






    }



}
