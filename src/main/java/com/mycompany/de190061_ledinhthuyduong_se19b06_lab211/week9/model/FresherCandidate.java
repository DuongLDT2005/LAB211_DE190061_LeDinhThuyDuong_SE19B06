/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class FresherCandidate extends Candidate{
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate(Date graduationDate, String graduationRank, String education, int candidateId, int candidateType, String firstName, String lastName, String address, String phone, String email, int birthDate) {
        super(candidateId, candidateType, firstName, lastName, address, phone, email, birthDate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + graduationDate + " | " + graduationRank + " | " + education;
    }
    
}
