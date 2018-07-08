package com.example.demo.entity;

import java.sql.Time;

public class Comment {
    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public Time getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    private String name;
    private  String comment;
    private Time time;
}
