/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.shape;

/**
 *
 * @author DELL
 */
public class Square extends TwoDimensionalShape{
    private double a;

    public Square(double a) {
        this.a = a;
    }
    
    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public void display() {
        System.out.println("Area of square: " + getArea());
    }
    
}
