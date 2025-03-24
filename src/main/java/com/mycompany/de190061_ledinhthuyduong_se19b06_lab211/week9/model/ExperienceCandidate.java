/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model;

/**
 *
 * @author DELL
 */
public class ExperienceCandidate extends Candidate{
    private int expInYear;
    private String proSkill;

    public ExperienceCandidate(int expInYear, String proSkill, int candidateId, int candidateType, String firstName, String lastName, String address, String phone, String email, int birthDate) {
        super(candidateId, candidateType, firstName, lastName, address, phone, email, birthDate);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    

    @Override
    public String toString() {
        return super.toString() + " | " + expInYear + " | " + proSkill;
    }
    
}
