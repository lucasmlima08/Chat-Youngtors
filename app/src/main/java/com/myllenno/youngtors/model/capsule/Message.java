package com.myllenno.youngtors.model.capsule;

import java.util.ArrayList;

public class Message {

    private int idSender;
    private ArrayList<Integer> idReceptors;
    private int idMessage;
    private String message;
    private String status;
    private String time;

    public Message(int idSender,
                   ArrayList<Integer> idReceptors,
                   int idMessage,
                   String message,
                   String status,
                   String time)
    {
        this.idSender = idSender;
        this.idReceptors = idReceptors;
        this.idMessage = idMessage;
        this.message = message;
        this.status = status;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }
}
