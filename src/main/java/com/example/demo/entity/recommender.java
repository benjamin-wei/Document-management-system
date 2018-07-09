package com.example.demo.entity;

public class recommender {
    private String Name;
    private String unit;
    private int telephone;
    private String recommended;
    private String jobTitle;
    private String email;
    private String reason;

    public String getName() {
        return Name;
    }

    public String getUnit() {
        return unit;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getRecommended() {
        return recommended;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public String getReason() {
        return reason;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setUnit(String unit){
        this.unit=unit;
    }

    public void setTelephone(int telephone){
        this.telephone=telephone;
    }

    public void setRecommended(String recommended){
        this.recommended=recommended;
    }

    public void seJobTitle(String jobTitle){
        this.jobTitle=jobTitle;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setReason(String reason){
        this.reason=reason;
    }

}
