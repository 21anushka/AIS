package com.example.ashish.railtellapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ashish.railtellapp.fragments.ProgressDialog;
import com.example.ashish.railtellapp.home.home;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button b1,b3;
    ProgressDialog dialog;
    public Button s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button login = (Button)findViewById(R.id.btnLogin);
        Button newUser = (Button)findViewById(R.id.btnLinkToRegisterScreen);
        login.setOnClickListener(this);
        newUser.setOnClickListener(this);

         username = (EditText)findViewById(R.id.email);
         password = (EditText)findViewById(R.id.password);

        Button tvForgotPassword = (Button)findViewById(R.id.b7);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        dialog = ProgressDialog.createDialog(this);
        s4=(Button)findViewById(R.id.b5);
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent research=new Intent(MainActivity.this,team.class);
                startActivity(research);
            }
        });

        b3 = (Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent research=new Intent(MainActivity.this,gallery.class);
                startActivity(research);
            }
        });

        tvForgotPassword.setOnClickListener(this);

        //tvNewUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1:
                Intent intro = new Intent(MainActivity.this, home.class);
                intro.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intro);
                break;
            case R.id.b7:
                CommonUtils.openContainerActivity(this,Constants.FORGOT_PASSWORD);
                break;
            case R.id.btnLinkToRegisterScreen:
                CommonUtils.openContainerActivity(this,Constants.NEW_USER);
                break;
            case R.id.btnLogin:
                int responseCode = 0;
                if(CommonUtils.isInternetAvailable(this)){
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    if (!user.isEmpty() && !pass.isEmpty()) {

                        dialog.show();
                        new MainActivity.RequestTask().execute("http://aisiitr.in/modis/login?txtusername="+user
                                +"&txtpassword="+pass);

                        Log.e("kkkkk","teri maa ki");

                        // writing response to logLog.e("Http Response:", response.toString()

                    } else {
                        // Prompt user to enter credentials
                        Toast.makeText(getApplicationContext(),
                                "Please enter the credentials!", Toast.LENGTH_LONG)
                                .show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "No Internet!", Toast.LENGTH_LONG)
                            .show();
                }


                break;
        }

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
            dialog.dismiss();
            Log.e("cfdfd", "" + result);
            result = result.replace(" ", "");
            if(!result.toLowerCase().contains("f")){
                Intent intent = new Intent(MainActivity.this,Welcome.class);
                startActivity(intent);
            }
            else{
                // Prompt user to enter credentials
                Toast.makeText(getApplicationContext(),
                        "Please enter correct credentials!", Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
}
