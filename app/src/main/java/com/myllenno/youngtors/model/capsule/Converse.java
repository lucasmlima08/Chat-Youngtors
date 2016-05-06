package com.myllenno.youngtors.model.capsule;

public class Converse {

    private String message;
    private String status;
    private String time;

    public Converse(String message,
                    String status,
                    String time)
    {
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
