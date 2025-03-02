/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.model;

/**
 *
 * @author DELL
 */
public class Contact {
    private static int currentID = 0;
    private int id;
    private String fullName, group, address, phone, firstName, lastName;

    public Contact() {
    }

    public Contact(String fullName, String group, String address, String phone) {
        this.id = ++currentID;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.firstName = fullName.split("\\s+")[0];
        this.lastName = fullName.split("\\s+")[1];
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-25s %-15s %-15s %-10s %-15s %-15s", id, fullName, firstName, lastName, group, address, phone);
    }
    
}
