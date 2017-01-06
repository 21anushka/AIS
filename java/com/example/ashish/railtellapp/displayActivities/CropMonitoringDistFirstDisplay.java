package com.example.ashish.railtellapp.displayActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ashish.railtellapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

/**
 * Created by Gaurav on 11-Nov-16.
 */

public class CropMonitoringDistFirstDisplay extends AppCompatActivity {

   // Button show;
    ImageView view1,view2,view3;
    private GoogleMap mgoogleMap;
    static final LatLng TutorialsPoint = new LatLng(21 , 57);
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
/*
        try {
            LatLng sydney = new LatLng(Double.parseDouble(ar[1]), Double.parseDouble(ar[2]));
            mgoogleMap.addMarker(new MarkerOptions().position(sydney));
            mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            CameraPosition position = CameraPosition.builder()
                    .target(sydney)
                    .zoom(12f)
                    .bearing(0.0f)
                    .tilt(0.0f)
                    .build();
            mgoogleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(position), null);
            mgoogleMap.getUiSettings().setZoomControlsEnabled(true);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        */
    }
}
