package com.example.ashish.railtellapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class preview2 extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview2);
        viewPager=(ViewPager)findViewById(R.id.preview2);
        adapter = new CustomSwipeAdapter2(this);
        viewPager.setAdapter(adapter);
    }
}
