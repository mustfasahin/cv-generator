package com.mustafa.CVMaker;

public class Education {

    private String date;
    private String schoolName;
    private String description;

    public Education(String date, String schoolName, String description){
        this.date = date;
        this.schoolName = schoolName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getDate() {
        return date;
    }
}