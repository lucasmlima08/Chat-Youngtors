package com.myllenno.youngtors.model.capsule;

public class FriendConverse {

    private int id;
    private String name;
    private String message;
    private String time;
    private String status;

    public FriendConverse(int id,
                          String name,
                          String message,
                          String time,
                          String status)
    {
        this.id = id;
        this.name = name;
        this.message = message;
        this.time = time;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getMessage(){
        return message;
    }

    public String getTime(){
        return time;
    }

    public String getStatus(){
        return status;
    }
}
