package com.example.ashish.railtellapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class preview3 extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter3 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview3);
        viewPager=(ViewPager)findViewById(R.id.preview3);
        adapter = new CustomSwipeAdapter3(this);
        viewPager.setAdapter(adapter);

    }
}
