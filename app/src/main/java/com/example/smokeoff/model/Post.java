package com.example.smokeoff.model;

import java.time.LocalDate;

public class Post {
    private Integer id;

    private String userId;

    private Integer noSmokingDay;

    private LocalDate date;

    private String note;

    public Post() {
    }

    public Post(Integer id, String userId, Integer noSmokingDay, LocalDate date, String note) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}