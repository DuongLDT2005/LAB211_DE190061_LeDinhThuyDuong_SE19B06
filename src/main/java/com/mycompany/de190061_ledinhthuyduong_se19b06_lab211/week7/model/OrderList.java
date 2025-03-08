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
public class OrderList {
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
}
