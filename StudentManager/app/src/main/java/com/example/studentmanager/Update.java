package com.example.studentmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Update extends AppCompatActivity {
Button update,fetch;
EditText e1,e2,e3,e4,e5;
String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        update = findViewById(R.id.update);
        fetch = findViewById(R.id.fetchdata);
        e1 = findViewById(R.id.rno);
        e2 = findViewById(R.id.name);
        e3 = findViewById(R.id.course);
        e4 = findViewById(R.id.sem);
        e5 = findViewById(R.id.fees);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1= e1.getText().toString();
                fetchdata();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1= e1.getText().toString();
                fetchdata();
            }
        });
    }
    public  void fetchdata()
    {
        RequestQueue rq = Volley.newRequestQueue(Update.this);
        String url = "http://192.168.43.116/student/fetch.php?rno="+s1;
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Update.this,"Fetched Successfully",Toast.LENGTH_SHORT).show();
                Showjson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Update.this,"Can't Fetched Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }

    public  void Showjson(String response)
    {
        String name1 = "";
        String course1 ="";
        String sem1 = "";
        String fees1 = "";

        try{
            JSONObject jo = new JSONObject(response);
            JSONArray jr = jo.getJSONArray("result");
            JSONObject jn = jr.getJSONObject(0);
            name1 = jn.getString("name");
            course1 = jn.getString("course");
            sem1 = jn.getString("sem");
            fees1 = jn.getString("fees");

        }catch (JSONException e){
            e.printStackTrace();
        }
        e2.setText(name1);
        e3.setText(course1);
        e4.setText(sem1);
        e5.setText(fees1);

    }
}

