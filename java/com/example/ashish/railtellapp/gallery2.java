package com.example.ashish.railtellapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class gallery2 extends AppCompatActivity {
    public Button g2;
    public void gallerynext2(){
        g2=(Button)findViewById(R.id.g2);
        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery_next2=new Intent(gallery2.this, gallery3.class);
                startActivity(gallery_next2);
            }
        });
    }

    ImageButton myImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery2);
        gallerynext2();
        myImageButton=(ImageButton)findViewById(R.id.imageButton2);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageclick=new Intent(gallery2.this, preview2.class);
                startActivity(imageclick);
            }
        });
    }
}
