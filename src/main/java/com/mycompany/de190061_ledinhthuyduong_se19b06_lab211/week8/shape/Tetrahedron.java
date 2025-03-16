/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.shape;

/**
 *
 * @author DELL
 */
public class Tetrahedron extends ThreeDimensionalShape{
    private double a;

    public Tetrahedron(double a) {
        this.a = a;
    }
    
    @Override
    public double getArea() {
        return this.a * this.a * Math.sqrt(3);
    }

    @Override
    public double getVolume() {
        return (this.a * this.a * this.a * Math.sqrt(2)) / 12;
    }

    @Override
    public void display() {
        System.out.println("Area of tetrahedron: " + getArea());
        System.out.println("Volume of tetrahedron: " + getVolume());
    }
    
}
