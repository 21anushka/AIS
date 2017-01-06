    package com.example.ashish.railtellapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class imageview1 extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter1 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview1);
        viewPager=(ViewPager)findViewById(R.id.imageview1);
        adapter = new CustomSwipeAdapter1(this);
        viewPager.setAdapter(adapter);
    }
}
