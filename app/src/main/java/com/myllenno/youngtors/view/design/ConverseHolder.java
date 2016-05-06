package com.myllenno.youngtors.view.design;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myllenno.youngtors.R;

public class ConverseHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private ImageView imageProfile;
    private TextView message, time;

    public ConverseHolder(View itemView, int id, String status) {
        super(itemView);
        if (status.equals("Send"))
            cardView = (CardView) itemView.findViewById(R.id.messageSend);
        else
            cardView = (CardView) itemView.findViewById(R.id.messageReceived);
        //imageProfile = (ImageView) itemView.findViewById(R.id.imageUser);
        message = (TextView) itemView.findViewById(R.id.message);
        //time = (TextView) itemView.findViewById(R.id.time);
    }

    public void setData(String status, int id, String message, String time){
        //if (status.equals("received"))
            // get image.
        this.message.setText(message);
        this.time.setText(time);
        cardView.setId(id);
    }
}