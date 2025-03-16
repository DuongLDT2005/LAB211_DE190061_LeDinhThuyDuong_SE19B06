/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.shape;

/**
 *
 * @author DELL
 */
public class Circle extends TwoDimensionalShape{
    private double r;

    public Circle(double r) {
        this.r = r;
    }
    
    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public void display() {
        System.out.println("Area of circle: " + getArea());
    } 
}
