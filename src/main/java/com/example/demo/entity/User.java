package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private String name;
    private String password;
    private String sex;
    private String homeAddress;
    private Integer telephone;
    private String recommender;
    private int industryClub;
    private int specialCommittee;

    public User(String username,
             String name,
             String password,
             String sex,
             String homeAddress,
             Integer telephone,
             String recommender,
             int industryClub,
             int specialCommittee){
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.homeAddress=homeAddress;
        this.telephone=telephone;
        this.recommender=recommender;
        this.industryClub=industryClub;
        this.specialCommittee=specialCommittee;
    }
    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getpassword(){ return password;}

    public String getHomeAddress() {
        return homeAddress;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public String getRecommender() {
        return recommender;
    }

    public int getIndustryClun() { return industryClub;
    }

    public int getSpecialCommittee() {
        return specialCommittee;
    }
}