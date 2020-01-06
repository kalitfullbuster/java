package com.example.studentmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class Selection extends AppCompatActivity {
ListView ls;
ImageView im1,im2,im3,im4;
Integer[] images = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        /*ls = findViewById(R.id.cuslist);
        Custom c = new Custom(this,images);
        ls.setAdapter(c);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Selection.this,Register.class);
                intent.putExtra("img",i);
                startActivity(intent);
            }
        });
        */
        im1 = findViewById(R.id.img1);
        im2 = findViewById(R.id.img2);
        im3 = findViewById(R.id.img3);
        im4 = findViewById(R.id.img4);

        im1.setImageResource(images[0]);
        im2.setImageResource(images[1]);
        im3.setImageResource(images[2]);
        im4.setImageResource(images[3]);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selection.this,Register.class);
                i.putExtra("img",images[0]);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selection.this,Register.class);
                i.putExtra("img",images[1]);
                startActivity(i);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selection.this,Register.class);
                i.putExtra("img",images[2]);
                startActivity(i);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selection.this,Register.class);
                i.putExtra("img",images[3]);
                startActivity(i);
            }
        });



    }
}
