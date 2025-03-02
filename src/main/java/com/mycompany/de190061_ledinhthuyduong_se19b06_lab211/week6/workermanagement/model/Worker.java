/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.model;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Worker {
    private String id, name, workLocation;
    private int age;
    private double salary;
    private ArrayList<SalaryHistory> salaryHistory;

    public Worker() {
    }

    public Worker(String id, String name, String workLocation, int age, double salary) {
        this.id = id;
        this.name = name;
        this.workLocation = workLocation;
        this.age = age;
        this.salary = salary;
        this.salaryHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void increaseSalary(double amount) {
        salaryHistory.add(new SalaryHistory("UP", salary += amount));
    }

    public void decreaseSalary(double amount) {
        salaryHistory.add(new SalaryHistory("DOWN", salary -= amount));
    }

    public ArrayList<SalaryHistory> getSalaryHistory() {
        return salaryHistory;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10d", id, name, age);
    }
    
}
