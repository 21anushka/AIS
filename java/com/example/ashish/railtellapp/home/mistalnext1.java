package com.example.ashish.railtellapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ashish.railtellapp.R;

public class mistalnext1 extends AppCompatActivity {
    public Button b3;
    public void more2()
    {
        b3=(Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent more2=new Intent(mistalnext1.this, mistalmore2.class);
                startActivity(more2);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mistalnext1);
        more2();
    }
}
