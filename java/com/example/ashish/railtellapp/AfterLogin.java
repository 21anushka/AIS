package com.example.ashish.railtellapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AfterLogin extends AppCompatActivity implements OnMapReadyCallback {

    Button show;
    ImageView view1,view2,view3;
    private GoogleMap mgoogleMap;
    static final LatLng TutorialsPoint = new LatLng(21 , 57);
    Spinner year,date,state,district;
    String[] y = {
            "2016",
            "2015",
            "2014",
            "2013",
            "2012",
            "2011"
    };
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
    String[] s = {
            "Punjab","Kerala","Tamil Nadu","Uttar Pradesh","Uttrakhand"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        show = (Button)findViewById(R.id.show_data);
        view1 = (ImageView) findViewById(R.id.view1);
        view2 = (ImageView) findViewById(R.id.view2);
        view3 = (ImageView) findViewById(R.id.view3);
        year =(Spinner)findViewById(R.id.year);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.
                R.layout.simple_spinner_dropdown_item ,y);

        year.setAdapter(adapter);

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=year.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You have selected City : " + y[sid],
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    date =(Spinner)findViewById(R.id.date);

    ArrayAdapter<String> adapterDate= new ArrayAdapter<String>(this,android.
            R.layout.simple_spinner_dropdown_item ,d);

    date.setAdapter(adapterDate);

    date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
        int position, long id) {
            // Get select item
            int sid=date.getSelectedItemPosition();
            Toast.makeText(getBaseContext(), "You have selected City : " + d[sid],
                    Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub
        }
    });

state =(Spinner)findViewById(R.id.state);

        ArrayAdapter<String> adapterState= new ArrayAdapter<String>(this,android.
        R.layout.simple_spinner_dropdown_item ,s);

        state.setAdapter(adapterState);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

@Override
public void onItemSelected(AdapterView<?> parent, View view,
        int position, long id) {
        // Get select item
        int sid=state.getSelectedItemPosition();
        Toast.makeText(getBaseContext(), "You have selected City : " + s[sid],
        Toast.LENGTH_SHORT).show();
        }
@Override
public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
        }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new RequestTask().execute("http://aisiitr.in/modis/index?cboyear=2015"+
                        "&cbojuliandate=001&cbostate=Uttrakhand&cbodistrict=Haridwar");
                //30.18
                //75
//http://aisiitr.in/modis/indexndviprofile?cbojuliandate1=001&cbostate1=Uttrakhand&cbodistrict1=Haridwar
            }
        });


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

}

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap = googleMap;
        mgoogleMap.getUiSettings().setScrollGesturesEnabled(false);

    }

    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
            Log.e("test","hello");
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            String responseString = null;
            try {
                response = httpclient.execute(new HttpGet(uri[0]));
                StatusLine statusLine = response.getStatusLine();
                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    responseString = out.toString();
                    out.close();
                } else{
                    //Closes the connection.
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
                //TODO Handle problems..
            } catch (IOException e) {
                //TODO Handle problems..
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //Do anything with response..
            Log.e("test",result+"");
            String[] ar=null;
            try {
                ar = result.split(",");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            String one = "http://aisiitr.in/modis/img/tmp/2015001"+ar[0]+".jpg";
            String one1 = "http://aisiitr.in/modis/img/tmp/2016001"+ar[0]+".jpg";
            String one2 = "http://aisiitr.in/modis/img/dist/" +"34"+"/Haridwar.jpg";


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

        }
    }
    private void initCamera(LatLng latLng) {
        CameraPosition position = CameraPosition.builder()
                .target(latLng)
                .zoom(16f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        mgoogleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), null);

        mgoogleMap.getUiSettings().setZoomControlsEnabled(true);
    }
}
