/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model;

/**
 *
 * @author DELL
 */
public class Person {
    private String id;
    private String fullname;
    private String phoneNumber;
    private int birthYear;
    private String major;

    public Person() {
        this.id = "";
        this.fullname = "";
        this.phoneNumber = "";
        this.birthYear = 0;
        this.major = "";
    }

    public Person(String id, String fullName, String phoneNumber, int birthYear, String major) {
        this.id = id;
        this.fullname = fullName;
        this.phoneNumber = phoneNumber;
        this.birthYear = birthYear;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-20s | %-17s | %-15d | %-22s", id, fullname, phoneNumber, birthYear, major);
    }
    
}
