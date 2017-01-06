package com.example.ashish.railtellapp;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Ashish
 * @since 8/20/2016
 */
public class CommonUtils {
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void openContainerActivity(Context context,int idValue){
        Intent intent = new Intent(context, LoginContainer.class);
        intent.putExtra("id", idValue);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
