package com.example.crudf.model;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    // private int id1;
    private String from1;
    private String to1;
    private  String created_at;

    public Contact() {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(int id, String from1, String to1, String created_at) {
        this.id = id;
        this.from1 = from1;
        this.to1 = to1;
        this.created_at = created_at;
    }

    public Contact(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFrom1() {
        return from1;
    }

    public void setFrom1(String from1) {
        this.from1 = from1;
    }

    public String getTo1() {
        return to1;
    }

    public void setTo1(String to1) {
        this.to1 = to1;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}