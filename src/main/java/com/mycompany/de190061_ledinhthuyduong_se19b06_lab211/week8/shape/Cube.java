/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.shape;

/**
 *
 * @author DELL
 */
public class Cube extends ThreeDimensionalShape{
    private double a;

    public Cube(double a) {
        this.a = a;
    }
    
    @Override
    public double getArea() {
        return 6 * this.a * this.a;
    }

    @Override
    public double getVolume() {
        return this.a * this.a * this.a;
    }

    @Override
    public void display() {
        System.out.println("Area cube: " + getArea());
        System.out.println("Volume cube: " + getVolume());
    }
    
}
