package com.example.ashish.railtellapp.fragments;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import com.example.ashish.railtellapp.Ankush;
//import com.example.ashish.railtellapp.Deepak;
import com.example.ashish.railtellapp.Dharmendra;
import com.example.ashish.railtellapp.R;
//import com.example.ashish.railtellapp.Shruti;
//import com.example.ashish.railtellapp.Tasneem;


public class ResearchTeam extends Fragment{
    public Button d1;
    public void next1() {
        d1=(Button) d1.findViewById(R.id.d1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                Dharmendra someFragment = new Dharmendra();
                transaction.replace(R.id.frame, someFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    public Button d4;
    public void next4()  {
        d4 = (Button) d4.findViewById(R.id.d4);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         /*       Ankush someFragment = new Ankush();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();
*/

            }
        });
    }

    public Button d2;
    public void next2() {
        d2=(Button) d2.findViewById(R.id.d2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        /*Tasneem someFragment = new Tasneem();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame, someFragment);
                transaction1.addToBackStack(null);
                transaction1.commit();*/
            }
        });
    }

    public Button d3;
    public void next3() {
        d3=(Button) d3.findViewById(R.id.d3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
                Shruti someFragment = new Shruti();
                transaction3.replace(R.id.frame, someFragment);
                transaction3.addToBackStack(null);
                transaction3.commit();*/
            }
        });
    }

    public Button d5;
    public void next5() {
        d5=(Button) d5.findViewById(R.id.d5);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   FragmentTransaction transaction5=getFragmentManager().beginTransaction();
                Deepak someFragment = new Deepak();
                transaction5.replace(R.id.frame, someFragment);
                transaction5.addToBackStack(null);
                transaction5.commit();*/
            }
        });
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_research_team, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        next1();
        next2();
        next3();
        next4();
        next5();
    }

}
