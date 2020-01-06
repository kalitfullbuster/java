package com.example.studentmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    Button register,update,add;
    EditText e1,e2,e3,e4,e5;
    String s1,s2,s3,s4,s5;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
     image = findViewById(R.id.image);
        Bundle extras = getIntent().getExtras();
        Selection s = new Selection();

        int pos = extras.getInt("img");
        image.setImageResource(pos);

        register = findViewById(R.id.register);
        update = findViewById(R.id.update);
        add = findViewById(R.id.add);
        e1 = findViewById(R.id.rollno);
        e2 = findViewById(R.id.name);
        e3 = findViewById(R.id.course);
        e4 = findViewById(R.id.sem);
        e5 = findViewById(R.id.fees);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameLayout layout = findViewById(R.id.frame);
                layout.setVisibility(View.VISIBLE);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                Register();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this,Update.class);
                startActivity(i);
            }
        });
    }
    public  void Register()
    {
        RequestQueue rq = Volley.newRequestQueue(Register.this);
        String url = "http://192.168.43.116/student/register.php";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this,"Not Registered",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hml = new HashMap<String,String>();
                hml.put("rno",s1);
                hml.put("name",s2);
                hml.put("course",s3);
                hml.put("sem",s4);
                hml.put("fees",s5);
                return hml;
            }
        };
        rq.add(sr);
    }
}
