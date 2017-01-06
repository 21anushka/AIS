package com.example.ashish.railtellapp.LoginSupportFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashish.railtellapp.R;

/**
 * @author Ashish
 * @since 8/20/2016
 */
public class ChangePassword extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.change_password, container, false);
    }
}
