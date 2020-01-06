package com.example.studentmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {
Button login;
EditText user,pass;
String s1,s2;
CheckBox c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        login = findViewById(R.id.login);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        c = findViewById(R.id.chkbox);
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(c.isChecked()==true)
                {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=user.getText().toString();
                s2 = pass.getText().toString();
                if(s1.contentEquals("admin")&&s2.contentEquals("123"))
                {
                    Intent i = new Intent(Home.this,Menu.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(Home.this,"Incorrect Details",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
