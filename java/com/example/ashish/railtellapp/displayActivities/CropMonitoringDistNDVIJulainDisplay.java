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

public class CropMonitoringDistNDVIJulainDisplay extends AppCompatActivity {
    String one;
    String[] p;
    String[] d = {
            "001: 01/Jan - 08/Jan",
            "009: 09/Jan - 16/Jan",
            "017: 17/Jan - 24/Jan",
            "025: 25/Jan - 01/Feb",
            "033: 02/Feb - 09/Feb",
            "041: 10/Feb - 17/Feb",
            "049: 18/Feb - 25/Feb",
            "057: 26/Feb - 05/Mar",
            "065: 06/Mar - 13/Mar",
            "073: 14/Mar - 21/Mar",
            "081: 22/Mar - 29/Mar",
            "089: 30/Mar - 06/Apr",
            "097: 07/Apr - 14/Apr",
            "105: 15/Apr - 22/Apr",
            "113: 23/Apr - 30/Apr",
            "121: 01/May - 08/May",
            "129: 09/May - 16/May",
            "137: 17/May - 24/May",
            "145: 25/May - 01/Jun",
            "153: 02/Jun - 07/Jun",
            "161: 08/Jun - 17/Jun",
            "169: 18/Jun - 25/Jun",
            "177: 26/Jun - 03/Jul",
            "185: 04/Jul - 11/Jul",
            "193: 12/Jul - 19/Jul",
            "201: 20/Jul - 27/Jul",
            "209: 28/Jul - 04/Aug",
            "217: 05/Aug - 12/Aug",
            "225: 13/Aug - 20/Aug",
            "233: 21/Aug - 28/Aug",
            "241: 29/Aug - 05/Sep",
            "249: 06/Sep - 14/Sep",
            "257: 15/Sep - 21/Sep",
            "265: 22/Sep - 29/Sep",
            "273: 30/Sep - 07/Oct",
            "281: 08/Oct - 15/Oct",
            "289: 16/Oct - 23/Oct",
            "297: 24/Oct - 31/Oct",
            "305: 01/Nov - 08/Nov",
            "313: 09/Nov - 16/Nov",
            "321: 17/Nov - 24/Nov",
            "329: 25/Nov - 02/Dec",
            "337: 02/Dec - 10/Dec",
            "345: 11/Dec - 18/Dec",
            "353: 19/Dec - 26/Dec",
            "361: 27/Dec - 31/Dec"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cm_dist_ndvi_julian_layout);
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
        int ba=d.length;
        for(int i=0;i<ba;i++){
            String[] aa=d[i].split("\\:");
            labels.add(aa[0]);
        }



        BarData data = new BarData(labels, dataset);

        barChart.setData(data);
        barChart.animateY(1000);
    }
}
