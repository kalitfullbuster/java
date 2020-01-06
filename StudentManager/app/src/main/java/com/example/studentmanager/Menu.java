package com.example.studentmanager;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
ImageView im;
Button btech,mca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        im = findViewById(R.id.image);
        im.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)im.getBackground()).start();


            }
        });
        btech = findViewById(R.id.btech);
        mca = findViewById(R.id.mca);
        btech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Menu.this,Selection.class);
                startActivity(i);
            }
        });
        mca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this,Selection.class);
                startActivity(intent);
            }
        });
    }
}
