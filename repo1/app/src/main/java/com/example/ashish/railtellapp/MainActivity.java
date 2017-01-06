package com.example.ashish.railtellapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvForgotPassword = (TextView)findViewById(R.id.forgot_password);
        TextView tvChangePassword = (TextView)findViewById(R.id.change_password);
        TextView tvNewUser = (TextView)findViewById(R.id.new_user);
        tvForgotPassword.setOnClickListener(this);
        tvChangePassword.setOnClickListener(this);
        tvNewUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_password:
                CommonUtils.openContainerActivity(this,Constants.CHANGE_PASSWORD);
                break;
            case R.id.forgot_password:
                CommonUtils.openContainerActivity(this,Constants.FORGOT_PASSWORD);
                break;
            case R.id.new_user:
                CommonUtils.openContainerActivity(this,Constants.NEW_USER);
                break;
        }

    }
}
