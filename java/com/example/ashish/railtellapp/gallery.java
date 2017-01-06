package com.example.ashish.railtellapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class gallery extends AppCompatActivity {
    public Button g1;
    public void gallery1(){
        g1=(Button)findViewById(R.id.g1);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery1_new=new Intent(gallery.this, gallery2.class);
                startActivity(gallery1_new);
            }
        });
    }
    ImageButton myImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        gallery1();
        myImageButton=(ImageButton)findViewById(R.id.imagebutton1);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageclick=new Intent(gallery.this, imageview1.class);
                startActivity(imageclick);
            }
        });
    }
}
