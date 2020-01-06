package com.example.studentmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom extends ArrayAdapter<String> {
    Activity c;
    //String[] s1;
    Integer[] img;
    public Custom(Context context, Integer[] textViewResourceId) {
        super(context, R.layout.activity_selection);

        c = (Activity)context;
       // s1= resource;
        img = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater Lf = c.getLayoutInflater();
        convertView = Lf.inflate(R.layout.custom,null);
        ImageView im = convertView.findViewById(R.id.cusimages);

        im.setImageResource(img[position]);

        return convertView;

    }
}