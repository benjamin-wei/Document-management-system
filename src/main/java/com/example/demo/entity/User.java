package com.example.demo.entity;

public class User {
    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getConWay() {
        return conWay;
    }

    public String getReferrer() {
        return referrer;
    }

    public String getAssoName() {
        return assoName;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setConWay(String conWay) {
        this.conWay = conWay;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public void setAssoName(String assoName) {
        this.assoName = assoName;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    private String userName;
    private String passWord;
    private String name;
    private  String gender;
    private int birthday;
    private  String address;
    private  String conWay;
    private String referrer;
    private String assoName;
    private int isAdmin;

}
