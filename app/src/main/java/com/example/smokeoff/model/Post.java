package com.example.smokeoff.model;


public class Post {
    private Integer id;

    private String userId;

    private Integer noSmokingDay;

    private String date;

    private String note;

    public Post() {
    }

    public Post(Integer id, String userId, Integer noSmokingDay, String date, String note) {
        this.id = id;
        this.userId = userId;
        this.noSmokingDay = noSmokingDay;
        this.date = date;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getNoSmokingDay() {
        return noSmokingDay;
    }

    public void setNoSmokingDay(Integer noSmokingDay) {
        this.noSmokingDay = noSmokingDay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}