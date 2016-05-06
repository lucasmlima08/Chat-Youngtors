package com.myllenno.youngtors.view.design;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myllenno.youngtors.R;
import com.myllenno.youngtors.model.capsule.FriendConverse;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsHolder> {

    private ArrayList<FriendConverse> friends;
    private String status;

    public FriendsAdapter(ArrayList<FriendConverse> friends, String status) {
        this.friends = friends;
        this.status = status;
    }

    @Override
    public FriendsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (status.equals("online"))
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friend_online, parent, false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friend_offline, parent, false);
        FriendsHolder friendsHolder = new FriendsHolder(v, viewType, status);
        return friendsHolder;
    }

    @Override
    public void onBindViewHolder(FriendsHolder holder, int position) {
        FriendConverse friendsModel = friends.get(position);
        holder.setData(friendsModel.getId(), friendsModel.getName(), friendsModel.getMessage(), friendsModel.getTime());
    }

    @Override
    public int getItemCount() {
        if (friends == null)
            return 0;
        else
            return friends.size();
    }
}
