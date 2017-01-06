package com.example.ashish.railtellapp.displayActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ashish.railtellapp.R;
import com.squareup.picasso.Picasso;

public class ClassificationDisplay extends AppCompatActivity {
    ImageView view1,view2,view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification_display);

        view1 = (ImageView) findViewById(R.id.view1);
        view2 = (ImageView) findViewById(R.id.view2);
        view3 = (ImageView) findViewById(R.id.view3);

        String one="",one1="",one2="";

        Bundle b = getIntent().getExtras();
        if(b!=null){
            one= (String) b.get("one");
            one1= (String) b.get("one1");
            one2= (String) b.get("one2");
        }

        Picasso.with(getApplication())
                .load(one)
                //.placeholder(R.drawable.pic1a)   // optional
                //.error(R.drawable.pic1a)
                //.resize(400,400)                        // optional
                .into(view1);
        Picasso.with(getApplication())
                .load(one1)
                //.placeholder(R.drawable.pic1a)   // optional
                //.error(R.drawable.pic1a)      // optional
                //.resize(400,400)                        // optional
                .into(view2);
        Picasso.with(getApplication())
                .load(one2)
                //.placeholder(R.drawable.pic1a)   // optional
                //.error(R.drawable.pic1a)      // optional
                //.resize(400,400)                        // optional
                .into(view3);
    }
}
