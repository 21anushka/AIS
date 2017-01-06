package com.example.ashish.railtellapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ashish.railtellapp.Constants;
import com.example.ashish.railtellapp.LoginSupportFragments.ChangePassword;
import com.example.ashish.railtellapp.LoginSupportFragments.ForgotPassword;
import com.example.ashish.railtellapp.LoginSupportFragments.NewUser;

public class LoginContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_container);
        int id = getIntent().getExtras().getInt("id");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (id){
            case Constants.CHANGE_PASSWORD:
                fragmentTransaction.replace(R.id.content, Fragment.instantiate(this,
                        ChangePassword.class.getName(),getIntent().getExtras()));
                break;
            case Constants.NEW_USER:
                fragmentTransaction.replace(R.id.content, Fragment.instantiate(this,
                        NewUser.class.getName(),getIntent().getExtras()));
                break;

            case Constants.FORGOT_PASSWORD:
                fragmentTransaction.replace(R.id.content, Fragment.instantiate(this,
                        ForgotPassword.class.getName(),getIntent().getExtras()));
                break;


        }
        fragmentTransaction.commit();

    }
}
