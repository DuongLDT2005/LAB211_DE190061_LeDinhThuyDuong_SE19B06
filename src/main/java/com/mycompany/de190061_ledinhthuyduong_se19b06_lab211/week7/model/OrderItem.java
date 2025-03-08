/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model;

/**
 *
 * @author DELL
 */
public class OrderItem {

    private int id, quantity;
    private String name;
    private double price;
    private double amount;
    
    public OrderItem(int id, int quantity, String name, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.amount = this.quantity * this.price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return String.format("%-16s %-11s %-12.2f %-12.2f", id + ". " + name, quantity, price, amount);
    }

}
