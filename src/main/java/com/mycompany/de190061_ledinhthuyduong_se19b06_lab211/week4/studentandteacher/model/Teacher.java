/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model;

/**
 *
 * @author DELL
 */
public class Teacher extends Person{
    private int professionYear;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.professionYear = 0;
        this.contractType = "";
        this.salaryCoefficient = 0;
    }

    public Teacher(String id, String fullName, String phoneNumber, int birthYear, String major, int professionYear, String contractType, double salaryCoefficient) {
        super(id, fullName, phoneNumber, birthYear, major);
        this.professionYear = professionYear;
        this.contractType = contractType;
        this.salaryCoefficient = salaryCoefficient;
    }

    public int getProfessionYear() {
        return professionYear;
    }

    public void setProfessionYear(int professionYear) {
        this.professionYear = professionYear;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %-25d | %-15s | %-25f", professionYear, contractType, salaryCoefficient);
    }

}
