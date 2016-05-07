package com.myllenno.youngtors.model.methods;

import android.content.Context;
import android.widget.Toast;

public class Basic {

    public String getDateAndHour(){
        return "";
    }

    public void showMessageLine(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
