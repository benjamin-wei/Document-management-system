package com.example.demo.entity;

import java.sql.Time;

public class Comment {
    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id;
    private String name;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private  String content;
    private Time time;
}
