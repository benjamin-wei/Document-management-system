package com.example.demo.entity;

public class Referrer {
    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getReason() {
        return reason;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReson(String reson) {
        this.reason = reason;
    }

    private String name;
    private String company;
    private String phone;
    private String jobTitle;
    private String position;
    private String email;
    private String reason;
}
