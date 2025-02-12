/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week3;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author DELL
 */
public class MyStack {
    private ArrayList<Integer> stackValues;

    public MyStack() {
        stackValues = new ArrayList<>();
    }
    
    public void push(int value) {
        stackValues.add(value);
        System.out.println("Pushed successfully!");
    }
    
    public int pop() {
        if (stackValues.isEmpty()) {
            return -1;
        } else {
            return stackValues.removeLast();
        }
    }
    
    public int get() {
        if (stackValues.isEmpty()) {
            return -1;
        } else {
            return stackValues.getLast();
        } 
    }
}
