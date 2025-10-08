package com.mustafa.CVMaker;

public class Person {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(String fullName, String address, String phoneNumber, String email){
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
