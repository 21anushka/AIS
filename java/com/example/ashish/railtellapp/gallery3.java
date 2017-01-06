package com.example.ashish.railtellapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class gallery3 extends AppCompatActivity {
    ImageButton myImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery3);
        myImageButton=(ImageButton)findViewById(R.id.imageButton3);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageclick=new Intent(gallery3.this, preview3.class);
                startActivity(imageclick);
            }
        });
    }
}
