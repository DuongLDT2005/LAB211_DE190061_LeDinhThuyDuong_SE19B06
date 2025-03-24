/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model;

/**
 *
 * @author DELL
 */
public class InternCandidate extends Candidate{
    private String majors, universityName;
    private int semester;

    public InternCandidate(String majors, String universityName, int semester, int candidateId, int candidateType, String firstName, String lastName, String address, String phone, String email, int birthDate) {
        super(candidateId, candidateType, firstName, lastName, address, phone, email, birthDate);
        this.majors = majors;
        this.universityName = universityName;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + majors + " | " + semester + " | " + universityName;
    }
    
}
