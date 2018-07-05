package com.example.demo.entity;

public class Proposal {
    public int getId() {
        return id;
    }

    public String getProName() {
        return proName;
    }

    public String getProWriter() {
        return proWriter;
    }

    public int getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public int getAgree() {
        return agree;
    }

    public int getOppose() {
        return oppose;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setProWriter(String proWriter) {
        this.proWriter = proWriter;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public void setOppose(int oppose) {
        this.oppose = oppose;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private int id;
    private String proName;
    private String proWriter;
    private int deadline;
    private String status;
    private int agree;
    private int oppose;
    private String content;
}
