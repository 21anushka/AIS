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
import com.example.ashish.railtellapp.displayActivities.CropMonitoringDistNdviYearDisplay;
import com.example.ashish.railtellapp.displayActivities.CropMonitoringTehsilNDVIYearDisplay;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CropMonitoringTehsilNdviYear extends Fragment {
    Button show;
    ImageView view1,view2,view3;
    private GoogleMap mgoogleMap;
    ProgressDialog dialog;
    static final LatLng TutorialsPoint = new LatLng(21 , 57);
    Spinner date,state,district,tehsil;

    String java1,java2,java3,java4,java5;

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
    String[] t = khali;
    String[] u = khali;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crop_monitoring_tehsil_ndvi_year, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Punjab Tehsil
        final String t_a1[] = new String[90];
        t_a1[1] = "Ajnala|Baba Bakala|Patti|Tarn Taran";
        t_a1[2] = "Bathinda|Rampura Phul|Talwandi Sabo";
        t_a1[3] = "Faridkot";
        t_a1[4] = "Sirhind";
        t_a1[5] = "Abohar|Fazilka|Firozpur|Zira";
        t_a1[6] = "Batala|Gurdaspur|Pathankot";
        t_a1[7] = "Dasua|Garhshankar|Hoshiarpur";
        t_a1[8] = "Jalandhar|Nakodar|Phillaur";
        t_a1[9] = "Kapurthala|Phagwara|Sultanpur Lodhi";
        t_a1[10] = "Jagraon|Khanna|Ludhiana|Samrala";
        t_a1[11] = "Mansa";
        t_a1[12] = "Moga";
        t_a1[13] = "Muktsar";
        t_a1[14] = "Balachaur|Nawashahr";
        t_a1[15] = "n.a. ( 155)|Nabha|Patiala|Rajpura|Samana";
        t_a1[16] = "Anandpur Sahib|Kharar|Rupnagar";
        t_a1[17] = "Barnala|Maler Kotla|Sangrur|Sunam";

//Kerela Tehsil
        final String[] t_a2 = new String[90];
        t_a2[1] = "Alleppey|Chengannur|Haripad|Mankombu|Mavelikara|n.a. ( 2250)|Shertallai";
        t_a2[2] = "Alwaye|Cochin|Ernakulam|Kotamangalam|Muvattupula|Parur|Perumbavur";
        t_a2[3] = "Devikolam|Pirmed|Todupulai|Udumbanchola";
        t_a2[4] = "Cannanore|Talipparamba|Tellicherry";
        t_a2[5] = "Hosdurg|Kasaragod";
        t_a2[6] = "Karunagapalli|Kottarakara|Kunnattur|Punalur|Quilon";
        t_a2[7] = "Changanacheri|Kanjirapalli|Kottayam|Pala (Lalam)|Vaikam";
        t_a2[8] = "Kozhikode|Mahe|Quilandi";
        t_a2[9] = "Malappuram|Perintalmanna|Ponnani|Tirur";
        t_a2[10] = "Alattur|Chittur|Mannarkkad|Ottappalam|Palghat";
        t_a2[11] = "Adur|Mallapalli|n.a. ( 2275)|Rani|Tiruvalla";
        t_a2[12] = "Chirayinkil|Nedumangad|Neyyattinkara|Trivandrum";
        t_a2[13] = "Chavakkad|Irinjalakuda|Kodungallur|Trichur|Vadakkancheri";
        t_a2[14] = "Manantavadi|Sultans Battery|Vayittiri";

//Tamil Nadu Tehsil
        //
        // t_a3 = new Array();
        final String[] t_a3 = new String[90];
        t_a3[1] = "Ariyalur|Udaiyarpalaiyam";
        t_a3[2] = "Egmore Nungabakkam|Fort Tondiarpet|Mambalam Gundy|Mylapore Tiruvallikk|Perambur Purasavakam";
        t_a3[3] = "Avanashi|Coimbatore|Mettuppalaiyam|Pollachi|Tiruppur|Udumalaippettai";
        t_a3[4] = "Chidambaram|Cuddalore|n.a. ( 2161)|Vriddhachalam";
        t_a3[5] = "Denkanikota|Dharmapuri|Harur|Hosur|Krishnagiri|Palakkodu|Pennagaram|Uttangarai";
        t_a3[6] = "Dindigul|Kodaikkanal|Nattam|Nilakkottai|Palani|Vedasandur";
        t_a3[7] = "Bhavani|Dharapuram|Erode|Gopichettipalaiyam|Perundurai|Satyamangalam";
        t_a3[8] = "Chengalpattu|Cheyyur|Kanchipuram|Madurantakam|Sriperumbudur|Uttiramerur";
        t_a3[9] = "Bhutapandi|Kuzhittura|Nagercoil|Takkalai";
        t_a3[10] = "Karur|Kulittalai";
        t_a3[11] = "Madurai|Melur|n.a. ( 2237)|Tirumangalam|Usilampatti|Vadippatti";
        t_a3[12] = "Mayuram|Nagappattinam|Sirkazhi|Tarangambadi|Tirutturaippundi";
        t_a3[13] = "Namakkal|Rasipuram|Tiruchengodu";
        t_a3[14] = "Coonoor|Gudalur|Kotagiri|Udagamandalam";
        t_a3[15] = "Perambalur";
        t_a3[16] = "Alangudi|Arantangi|Kulattur|n.a. ( 2236)|Pudukkottai|Tirumayam";
        t_a3[17] = "Kamudi|Mudukulattur|Paramakkudi|Ramanathapuram|Rameswaram|Tiruvadanai";
        t_a3[18] = "Attur|Mettur|Omalur|Salem|Sankari";
        t_a3[19] = "Devakottai|Ilaiyankudi|Karaikkudi|Manamadurai|Sivaganga|Tiruppattur";
        t_a3[20] = "Kumbakonam|Orattanadu|Papanasam|Pattukkottai|Peravurani|Thanjavur|Tiruvidaimarudur";
        t_a3[21] = "Periyakulam|Uttamapalaiyam";
        t_a3[22] = "Gummidipundi|Pallippattu|Ponneri|Saidapet|Tiruttani|Tiruvallur|Uttukkottai";
        t_a3[23] = "Mannargudi|Nannilam|Thiruvarur";
        t_a3[24] = "Kovilpatti|Ottapidaram|Sattankulam|Srivaikuntam|Tiruchchendur|Tuticorin|Vilattikulam";
        t_a3[25] = "Lalgudi|Manapparai|Musiri|Tiruchchirappalli|Turaiyur";
        t_a3[26] = "Ambasamudram|Nanguneri|Palayankottai|Radhapuram|Sankarankovil|Sengottai|Sivagiri|Tenkasi|Tirunelveli";
        t_a3[27] = "Arani|Chengam|Polur|Tiruvannamalai|Tiruvettipuram|Vandavasi";
        t_a3[28] = "Arakkonam|Arcot|Gudiyattam|Tiruppattur|Vaniyambadi|Vellore|Walajapet";
        t_a3[29] = "Gingee|Kallakkurichchi|Tindivanam|Tirukkoyilur|Viluppuram";
        t_a3[30] = "Aruppukottai|Rajapalaiyam|Sattur|Srivilliputtur|Tiruchuli|Virudunagar";

//Uttar Pradesh Tehsil
        final String[] t_a4 = new String[90];
        t_a4[1] = "Agra|Bah|Fatehabad|Khairagarh|Kiraoli";
        t_a4[2] = "Aligarh|Atrauli|Iglas|Khair|Sikandra Rao";
        t_a4[3] = "Handia|Karchana|Meja|Phulpur|Soraon";
        t_a4[4] = "Akbarpur|Tanda";
        t_a4[5] = "Auraiya|Bidhuna";
        t_a4[6] = "Azamgarh|Katghar|Phulpur|Sagri";
        t_a4[7] = "Bisauli|Budaun|Dataganj|Gunnaur|Sahaswan";
        t_a4[8] = "Baghpat";
        t_a4[9] = "Kaisarganj|Nanpara";
        t_a4[10] = "Ballia|Bansdih|Rasra";
        t_a4[11] = "Balrampur";
        t_a4[12] = "Baberu|Banda|Naraini";
        t_a4[13] = "Bara Banki|Fatehpur|Haidargarh|Ramsanehighat";
        t_a4[14] = "Aonla|Baheri|Bareilly|Faritpur|Nawabganj";
        t_a4[15] = "Basti|Haraiya";
        t_a4[16] = "Bijnor|Dhampur|Nagina|Najibabad";
        t_a4[17] = "Anupshahr|Bulandshahr";
        t_a4[18] = "Chakia|Chandauli";
        t_a4[19] = "Karwi|Mau";
        t_a4[20] = "Deoria|Salempur";
        t_a4[21] = "Aliganj|Etah|Jalesar|Kasganj";
        t_a4[22] = "Bharthana|Etawah";
        t_a4[23] = "Bikapur|Faizabad";
        t_a4[24] = "Fatehgarh|Kaimganj";
        t_a4[25] = "Bindki|Fatehpur|Khaga";
        t_a4[26] = "Etmadpur|Firozabad|Jasrana|Shikohabad";
        t_a4[27] = "Dadri|Khurja|Sikandarabad";
        t_a4[28] = "Garhmuktesar|Ghaziabad|Hapur";
        t_a4[29] = "Ghazipur|Muhammadabad|Saidpur|Zamania";
        t_a4[30] = "Gonda|Tarabganj|Utraula";
        t_a4[31] = "Bansgaon|Gorakhpur";
        t_a4[32] = "Hamirpur|Maudaha|Rath";
        t_a4[33] = "Bilgram|Hardoi|Sandila|Shahabad";
        t_a4[34] = "Hathras";
        t_a4[35] = "Jalaun|Kalpi|Konch|Orai";
        t_a4[36] = "Jaunpur|Kirakat|Machhlishahr|Mariahu|Shahganj";
        t_a4[37] = "Garautha|Jhansi|Mau Ranipur|Moth";
        t_a4[38] = "Amroha|Hasanpur";
        t_a4[39] = "Chhibramau|Kannauj";
        t_a4[40] = "Akbarpur|Bilhaur|Derapur|Ghatampur|Pukhrayan";
        t_a4[41] = "Kanpur";
        t_a4[42] = "Allahabad|Manjhanpur|Sirathu";
        t_a4[43] = "Hata|Padrauna";
        t_a4[44] = "Lakhimpur|Muhamdi|Nighasan";
        t_a4[45] = "Lalitpur|Mahrauni";
        t_a4[46] = "Lucknow|Malihabad|Mohanlalganj";
        t_a4[47] = "Maharajganj|Pharenda";
        t_a4[48] = "Charkhari|Kulpahar|Mahoba";
        t_a4[49] = "Bhongaon|Karhal|Mainpuri";
        t_a4[50] = "Chhata|Mat|Mathura|Sadabad";
        t_a4[51] = "Ghosi|Mau";
        t_a4[52] = "Mawana|Meerut|Sardhana";
        t_a4[53] = "Chunar|Mirzapur";
        t_a4[54] = "Bilari|Moradabad|Sambhal|Thakurdwara";
        t_a4[55] = "Budhana|Jansath|Kairana|Muzaffarnagar";
        t_a4[56] = "Bisalpur|Pilibhit|Puranpur ";
        t_a4[57] = "Bela|Kunda|Patti";
        t_a4[58] = "Dalmau|Maharajganj|Rae Bareli|Salon";
        t_a4[59] = "Bilaspur|Milak|Rampur|Shahabad|Suar";
        t_a4[60] = "Deoband|Nakur|Saharanpur";
        t_a4[61] = "Khalilabad";
        t_a4[62] = "Gyanpur";
        t_a4[63] = "Jalalabad|Pawayan|Shahjahanpur|Tilhar";
        t_a4[64] = "Bahraich";
        t_a4[65] = "Bansi|Domriaganj|Naugarh";
        t_a4[66] = "Biswan|Misrikh|Sidhauli|Sitapur";
        t_a4[67] = "Dudhi|Robertsganj";
        t_a4[68] = "Amethi|Gauriganj|Kadipur|Musafirkhana|Sultanpur";
        t_a4[69] = "Hasanganj|Purwa|Safipur|Unnao";
        t_a4[70] = "Varanasi";

// Uttarakhand Tehsil
        final String[] t_a5 = new String[90];
        t_a5[1] = "Almora|Ranikhet";
        t_a5[2] = "Bageshwar";
        t_a5[3] = "Chamoli|Joshimath|Karnaprayag";
        t_a5[4] = "Champawat";
        t_a5[5] = "Chakrata|Dehra Dun";
        t_a5[6] = "Haridwar|Roorkee";
        t_a5[7] = "Haldwani|n.a. ( 188)|Naini Tal";
        t_a5[8] = "Lansdowne|Pauri";
        t_a5[9] = "Dharchula|Didihat|Munsyari|Pithoragarh";
        t_a5[10] = "Okhimath";
        t_a5[11] = "n.a. ( 111)|Narendranagar|Tehri";
        t_a5[12] = "Bazpur|Kashipur|Khatima|Kichha";
        t_a5[13] = "Bhatwari|Dunda|Purola|Rajgarhi";

        show = (Button)view.findViewById(R.id.show_data);
        view1 = (ImageView) view.findViewById(R.id.view1);
        view2 = (ImageView) view.findViewById(R.id.view2);
        view3 = (ImageView) view.findViewById(R.id.view3);



        date =(Spinner)view.findViewById(R.id.date);

        ArrayAdapter<String> adapterDate= new ArrayAdapter<String>(getActivity(),android.
                R.layout.simple_spinner_dropdown_item ,d);

        date.setAdapter(adapterDate);
        dialog = ProgressDialog.createDialog(getActivity());
        date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=date.getSelectedItemPosition();
                java2=d[sid];
                Toast.makeText(getActivity(), "You have selected City : " + d[sid],
                        Toast.LENGTH_SHORT).show();
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
        tehsil =(Spinner)view.findViewById(R.id.tehsil);

        ArrayAdapter<String> adapterTehsil= new ArrayAdapter<String>(getActivity(),android.
                R.layout.simple_spinner_dropdown_item , t);

        tehsil.setAdapter(adapterTehsil);


        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid = state.getSelectedItemPosition();
                if (sid == 0) {
                    p = pun;
                    t = t_a1;

                } else if (sid == 1) {
                    p = ker;
                    t = t_a2;
                } else if (sid == 2) {
                    p = tam;
                    t = t_a3;
                } else if (sid == 3) {
                    p = up;
                    t = t_a4;
                } else if (sid == 4) {
                    p = utt;
                    t = t_a5;
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

                String B=t[sid+1];
                u=B.split("\\|");
                Log.e("ypoi",B);

                ArrayAdapter<String> adapterTehsil2 = new ArrayAdapter<String>(getActivity(), android.
                        R.layout.simple_spinner_dropdown_item,u);

                tehsil.setAdapter(adapterTehsil2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        tehsil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Get select item
                int sid=tehsil.getSelectedItemPosition();
                java5=u[sid];
                Toast.makeText(getActivity(), "You have selected City : " + u[sid],
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
                String[] a=java2.split("\\:");
                if(CommonUtils.isInternetAvailable(getActivity())) {
                    dialog.show();
                    new RequestTask().execute("http://aisiitr.in/modis/indexndviprofiletehsil?cbojuliandate1=" + a[0] +
                            "&cbostate1=" + java3 + "&cbodistrict1=" + java4 + "&cbotehsil1=" + java5);
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
            Intent intent = new Intent(getActivity(), CropMonitoringTehsilNDVIYearDisplay.class);
dialog.dismiss();
            Bundle b = new Bundle();
            b.putString("one1",result);
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);

        }
    }
}
