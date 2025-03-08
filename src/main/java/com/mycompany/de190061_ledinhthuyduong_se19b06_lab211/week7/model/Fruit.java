/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.model;

/**
 *
 * @author DELL
 */
public class Fruit {
    private int id, quantity;
    private String name, origin;
    private double price;

    public Fruit() {
    }

    public Fruit(int id, int quantity, String name, String origin, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.origin = origin;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return String.format("%-10d %-18s %-18s %-10.2f %-10d", id, name, origin, price, quantity);
    }
    
}
