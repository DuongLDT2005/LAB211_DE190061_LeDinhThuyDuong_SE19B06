/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.shape;

/**
 *
 * @author DELL
 */
public class Sphere extends ThreeDimensionalShape{
    private double r;

    public Sphere(double r) {
        this.r = r;
    }
    
    @Override
    public double getArea() {
        return 4 * Math.PI * this.r * this.r;
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * this.r * this.r * this.r) / 3;
    }

    @Override
    public void display() {
        System.out.println("Area of sphere: " + getArea());
        System.out.println("Volume of sphere: " + getVolume());
    }
    
}
