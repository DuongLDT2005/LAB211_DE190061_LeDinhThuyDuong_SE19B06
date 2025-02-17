/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model;

/**
 *
 * @author DELL
 */
public class Student extends Person implements Comparable<Student>{
    private int admissionYear;
    private int englishScore;

    public Student() {
        super();
        this.admissionYear = 0;
        this.englishScore = 0;
    }

    public Student(String id, String fullName, String phoneNumber, int birthYear, String major, int admissionYear, int englishScore) {
        super(id, fullName, phoneNumber, birthYear, major);
        this.admissionYear = admissionYear;
        this.englishScore = englishScore;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %-20d | %-25d", admissionYear, englishScore);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.admissionYear, other.admissionYear);
    }
    
}
