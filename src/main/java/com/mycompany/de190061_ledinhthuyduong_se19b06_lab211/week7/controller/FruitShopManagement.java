/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week7.view.FruitListView;

/**
 *
 * @author DELL
 */
public class FruitShopManagement {
    public static void main(String[] args) {
        FruitListView fruitLV = new FruitListView();
        String[] options = {
            "Create Fruit",
            "View orders",
            "Shopping (for buyer)"
        };
        Menu menu = new Menu("FRUIT SHOP SYSTEM", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        fruitLV.addFruit();
                        break;
                    }
                    case 2 -> {
                        fruitLV.viewOrders();
                        break;
                    }
                    case 3 -> {
                        fruitLV.shopping();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
