package com.mustafa.CVMaker;

public class WorkExperience {

    private String date;
    private String company;
    private String role;
    private String description;

    public WorkExperience(String date, String company, String role, String description){
        this.date = date;
        this.company = company;
        this.role = role;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }
}
