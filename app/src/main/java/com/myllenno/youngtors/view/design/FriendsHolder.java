package com.myllenno.youngtors.view.design;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myllenno.youngtors.R;

public class FriendsHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private ImageView imageProfile;
    private TextView name, message, time;

    public FriendsHolder(View itemView, int id, String status) {
        super(itemView);
        if (status.equals("online"))
            cardView = (CardView) itemView.findViewById(R.id.friendOnline);
        else
            cardView = (CardView) itemView.findViewById(R.id.friendOffline);
        //imageProfile = (ImageView) itemView.findViewById(R.id.image);
        name = (TextView) itemView.findViewById(R.id.nameFriend);
        message = (TextView) itemView.findViewById(R.id.messageFriend);
        time = (TextView) itemView.findViewById(R.id.timeFriend);
    }

    public void setData(int id, String name, String message, String time){
        // get image friend.
        this.name.setText(name);
        this.message.setText(message);
        this.time.setText(time);
        cardView.setId(id);
    }
}
