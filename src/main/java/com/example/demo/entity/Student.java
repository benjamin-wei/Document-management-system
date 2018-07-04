package com.example.demo.entity;

import lombok.Data;

/**
 * @description
 * @author Tim Lin
 * @create 2018-07-01
 **/
@Data
public class Student {
    private String name;
    private String password;
    private String sex;
    private String homeAddress;
    private Integer telephone;
    private String recommender;
    private String industryClub;
    private String specialCommittee;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public String getRecommender() {
        return recommender;
    }

    public String getIndustryClun() {
        return industryClub;
    }

    public String getSpecialCommittee() {
        return specialCommittee;
    }
}