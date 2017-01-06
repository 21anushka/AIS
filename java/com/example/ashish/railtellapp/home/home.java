package com.example.ashish.railtellapp.home;

/**
 * Created by Kapil Batra on 07-06-2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ashish.railtellapp.R;

public class home extends AppCompatActivity {
    public Button n1;
    public void more1() {
        n1 = (Button) findViewById(R.id.n1);
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intro1 = new Intent(home.this, mistalmore.class);
                startActivity(intro1);
            }
        });
    }
    public Button n2;
    public void next1(){
        n2=(Button) findViewById(R.id.n2);
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next1 = new Intent(home.this, mistalnext1.class);
                startActivity(next1);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        more1();
        next1();
    }
}

