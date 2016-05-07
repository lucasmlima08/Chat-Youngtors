package com.myllenno.youngtors.view.design;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myllenno.youngtors.R;
import com.myllenno.youngtors.model.capsule.Message;

import java.util.ArrayList;

public class ConverseAdapter extends RecyclerView.Adapter<ConverseHolder> {

    private ArrayList<Message> converse;
    private String status;

    public ConverseAdapter(ArrayList<Message> converse, int id, String status){
        this.converse = converse;
        this.status = status;
    }

    @Override
    public ConverseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (status.equals("send"))
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_message_send, parent, false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_message_received, parent, false);
        ConverseHolder converseHolder = new ConverseHolder(v, viewType, "");
        return converseHolder;
    }

    @Override
    public void onBindViewHolder(ConverseHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
