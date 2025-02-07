/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week3;

import java.util.Stack;

/**
 *
 * @author DELL
 */
public class MyStack {
    private Stack<Integer> stackValues;

    public MyStack() {
        stackValues = new Stack<>();
    }
    
    public void push(int value) {
        stackValues.push(value);
        System.out.println("Pushed successfully!");
    }
    
    public int pop() {
        if (stackValues.isEmpty()) {
            return -1;
        } else {
            return stackValues.pop();
        }
    }
    
    public int get() {
        if (stackValues.isEmpty()) {
            return -1;
        } else {
            return stackValues.peek();
        } 
    }
}
