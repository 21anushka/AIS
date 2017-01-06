package com.example.ashish.railtellapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ashish.railtellapp.CommonUtils;
import com.example.ashish.railtellapp.R;
import com.example.ashish.railtellapp.displayActivities.CropMonitoringDistNDVIJulainDisplay;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CropMonitoringDistNdviJulian extends Fragment {

    Button show;
    ImageView view1,view2,view3;
    private GoogleMap mgoogleMap;
     ProgressDialog dialog;

    static final LatLng TutorialsPoint = new LatLng(21 , 57);
    Spinner date,year,state,district;

    String java1,java2,java3,java4;

    String[] y = {
            "2016",
            "2015",
            "2014",
            "2013",
            "2012",
            "2011"
    };
    String[] s = {
            "Punjab","Kerala","Tamil Nadu","Uttar Pradesh","Uttrakhand"
    };
    String[] khali = {
    };
    String[] pun = {
            "Amritsar","Bathinda","Faridkot","Fatehgarh Sahib","Firozpur","Gurdaspur","Hoshiarpur","Jalandhar","Kapurthala","Ludhiana","Mansa","Moga","Muktsar","Nawan Shehar","Patiala","Rupnagar","Sangrur"
    };
    String[] ker = {
            "Alappuzha","Ernakulam","Idukki","Kannur","Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pattanamtitta","Thiruvananthapuram","Thrissur","Wayanad"
    };
    String[] tam = {
            "Ariyalur","Chennai","Coimbatore","Cuddalore","Dharmapuri","Dindigul","Erode","Kancheepuram","Kanniyakumari","Karur","Madurai","Nagapattinam","Namakkal","Nilgiris","Perambalur","Pudukkottai","Ramanathapuram","Salem","Sivaganga","Thanjavur","Theni","Thiruvallur","Thiruvarur","Thoothukudi","Tiruchchirappalli","Tirunelveli Kattabo","Tiruvannamalai","Vellore","Villupuram","Virudhunagar"
    };
    String[] up = {
            "Agra","Aligarh","Allahabad","Ambedkar Nagar","Auraiya","Azamgarh","Badaun","Baghpat","Bahraich","Ballia","Balrampur","Banda","Bara Banki","Bareilly","Basti","Bijnor","Bulandshahr","Chandauli","Chitrakoot","Deoria","Etah","Etawah","Faizabad","Farrukhabad","Fatehpur","Firozabad","Gautam Buddha Nagar","Ghaziabad","Ghazipur","Gonda","Gorakhpur","Hamirpur","Hardoi","Hathras","Jalaun","Jaunpur","Jhansi","Jyotiba Phule Nagar","Kannauj","Kanpur Dehat","Kanpur","Kaushambi","Kushinagar","Lakhimpur Kheri","Lalitpur","Lucknow","Maharajganj","Mahoba","Mainpuri","Mathura","Mau","Meerut","Mirzapur","Moradabad","Muzaffarnagar","Pilibhit","Pratapgarh","Rae Bareli","Rampur","Saharanpur","Sant Kabir Nagar","Sant Ravi Das Nagar","Shahjahanpur","Shravasti","Siddharth Nagar","Sitapur","Sonbhadra","Sultanpur","Unnao","Varanasi"
    };
    String[]  utt= {
            "Almora","Bageshwar","Chamoli","Champawat","Dehra Dun","Haridwar","Naini Tal","Pauri Garhwal","Pithoragarh","Rudra Prayag","Tehri Garhwal","Udham Singh Nagar","Uttarkashi"

    };
    String[] p = khali;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crop_monitoring_dist_ndvi_year, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        show = (Button)view.findViewById(R.id.show_data);
        view1 = (ImageView) view.findViewById(R.id.view1);
        view2 = (ImageView) view.findViewById(R.id.view2);
        view3 = (ImageView) view.findViewById(R.id.view3);
        year =(Spinner)view.findViewById(R.id.year);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity(),android.
                R.layout.simple_spinner_dropdown_item ,y);

        year.setAdapter(adapter);

        dialog = ProgressDialog.createDialog(getActivity());

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=year.getSelectedItemPosition();
                java1=y[sid];
                //Toast.makeText(getActivity(), "You have selected City : " + y[sid],
                //      Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        state =(Spinner)view.findViewById(R.id.state);

        ArrayAdapter<String> adapterState= new ArrayAdapter<String>(getActivity(),android.
                R.layout.simple_spinner_dropdown_item ,s);

        state.setAdapter(adapterState);
        district =(Spinner)view.findViewById(R.id.district);

        ArrayAdapter<String> adapterDistrict= new ArrayAdapter<String>(getActivity(),android.
                R.layout.simple_spinner_dropdown_item , p);

        district.setAdapter(adapterDistrict);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid = state.getSelectedItemPosition();
                if (sid == 0) {
                    p = pun;

                } else if (sid == 1) {
                    p = ker;
                } else if (sid == 2) {
                    p = tam;
                } else if (sid == 3) {
                    p = up;
                } else if (sid == 4) {
                    p = utt;
                }
                ArrayAdapter<String> adapterDistrict2 = new ArrayAdapter<String>(getActivity(), android.
                        R.layout.simple_spinner_dropdown_item, p);

                district.setAdapter(adapterDistrict2);
                java3 = s[sid];
                Toast.makeText(getActivity(), "You have selected City : " + s[sid],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=district.getSelectedItemPosition();
                java4=p[sid];
                Toast.makeText(getActivity(), "You have selected City : " + p[sid],
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
                if(CommonUtils.isInternetAvailable(getActivity())) {
                    dialog.show();
                    new RequestTask().execute("http://aisiitr.in/modis/ndviprofileyear?cboyear2=" + java1
                            + "&cbostate2=" + java3 + "&cbodistrict2=" + java4);
                }
                else {
                    Toast.makeText(getActivity(),
                            "No Internet!", Toast.LENGTH_LONG)
                            .show();
                }
                //30.18
                //75
//http://aisiitr.in/modis/indexndviprofile?cbojuliandate1=001&cbostate1=Uttrakhand&cbodistrict1=Haridwar
            }
        });


        // SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        //       .findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);

    }
    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
            Log.e("test", "hello");
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
            //Do anything with response.
            Intent intent = new Intent(getActivity(), CropMonitoringDistNDVIJulainDisplay.class);
dialog.dismiss();
            Bundle b = new Bundle();
            b.putString("one1", result);
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);




        }
    }
}
