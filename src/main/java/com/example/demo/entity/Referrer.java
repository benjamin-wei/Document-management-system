package com.example.demo.entity;

public class Referrer {
    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNobody(String nobody) {
        this.nobody = nobody;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String name;
    private String jobTitle;
    private String company;
    private String position;
    private String phone;
    private String email;
    private String nobody;
    private String reason;

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNobody() {
        return nobody;
    }

    public String getReason() {
        return reason;
    }
}
