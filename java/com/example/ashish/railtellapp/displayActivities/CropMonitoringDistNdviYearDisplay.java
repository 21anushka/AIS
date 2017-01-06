package com.example.ashish.railtellapp.displayActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ashish.railtellapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

/**
 * Created by Gaurav on 12-Nov-16.
 */

public class CropMonitoringDistNdviYearDisplay extends AppCompatActivity {
    String one;
    String[] p;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cm_nvdi_year_dist_display_layout);
        BarChart barChart = (BarChart) findViewById(R.id.chart);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            one= (String) b.get("one1");

        }
        Log.e("one",one);
        p=one.split(",");
        int a=p.length;
        ArrayList<BarEntry> entries = new ArrayList<>();

        for(int i=0;i<a;i++){
            entries.add(new BarEntry(Float.parseFloat(p[i]), i));
        }
        BarDataSet dataset = new BarDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("2011");
        labels.add("2012");
        labels.add("2013");
        labels.add("2014");
        labels.add("2015");
        labels.add("2016");


        BarData data = new BarData(labels, dataset);

        barChart.setData(data);
        barChart.animateY(1000);

    }
}
