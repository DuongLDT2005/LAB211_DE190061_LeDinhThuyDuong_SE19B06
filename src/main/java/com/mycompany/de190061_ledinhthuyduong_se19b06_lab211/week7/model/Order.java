/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Order {

    private String customerName;
    private ArrayList<OrderItem> items;
    private double total;

    public Order(ArrayList<OrderItem> items) {
        this.items = items;
        this.total = calculateTotal();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public double calculateTotal() {
        for (OrderItem item : items) {
            total += item.getAmount();
        }
        return total;
    }

}
