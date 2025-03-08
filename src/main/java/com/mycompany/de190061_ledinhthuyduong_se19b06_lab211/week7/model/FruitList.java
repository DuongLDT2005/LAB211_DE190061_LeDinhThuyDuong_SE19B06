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
public class FruitList {
    private ArrayList<Fruit> fruits;

    public FruitList() {
        this.fruits = new ArrayList<>();
    }    

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }    

    public Fruit searchSelectedFruit(int id) {
        for (Fruit f : fruits) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }
}
