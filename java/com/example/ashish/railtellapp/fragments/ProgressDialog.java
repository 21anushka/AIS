package com.example.ashish.railtellapp.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.ashish.railtellapp.R;

public class ProgressDialog extends android.app.ProgressDialog {

    public static ProgressDialog createDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setCancelable(false);
        return dialog;
    }

    private ProgressDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog_layout);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar.getProgressDrawable().setColorFilter(Color.parseColor("#1b91d5"), PorterDuff.Mode.MULTIPLY);
    }

}
