package com.example.crudf.model;

public class UserAct {
    private int id1;
    private String from;
    private String to;

    public UserAct(int id1, String from, String to) {
        this.id1 = id1;
        this.from = from;
        this.to = to;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

