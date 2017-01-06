package com.example.ashish.railtellapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class team extends AppCompatActivity {
    public Button d1;
    public void Dharmendra(){
        d1=(Button)findViewById(R.id.d1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail=new Intent(team.this,prof.class);
                startActivity(detail);
            }
        });
    }
    public Button d2;
    public void Scholar1(){
        d2=(Button)findViewById(R.id.d2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail2=new Intent(team.this, tasneem.class);
                startActivity(detail2);
            }
        });
    }
    public Button d3;
    public void Scholar2(){
        d3=(Button)findViewById(R.id.d3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail3=new Intent(team.this, shruti.class);
                startActivity(detail3);
            }
        });
    }
    public Button d4;
    public void Scholar3(){
        d4=(Button)findViewById(R.id.d4);
        d4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail4=new Intent(team.this, ankush.class);
                startActivity(detail4);
            }
        }));
    }
    public Button d5;
    public void Scholar4(){
        d5=(Button)findViewById(R.id.d5);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail5=new Intent(team.this, deepak.class);
                startActivity(detail5);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        Dharmendra();
        Scholar1();
        Scholar2();
        Scholar3();
        Scholar4();
    }
}
