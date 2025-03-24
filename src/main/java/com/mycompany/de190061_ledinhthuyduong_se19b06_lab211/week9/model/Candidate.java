/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model;

/**
 *
 * @author DELL
 */
public class Candidate {
    private int candidateId, candidateType;
    private String firstName, lastName, address, phone, email;
    private int birthDate;

    public Candidate() {
    }

    public Candidate(int candidateId, int candidateType, String firstName, String lastName, String address, String phone, String email, int birthDate) {
        this.candidateId = candidateId;
        this.candidateType = candidateType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getBirthDate() {
        return birthDate;
    }
    
    public int getCandidateType() {
        return candidateType;
    }
    
    @Override
    public String toString() {
        return candidateId + " | " +  firstName + " " + lastName + " | " + birthDate + " | " + address + " | " + phone + " | " + email + " | " + candidateType;
    }
    
}
