/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.shape;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;

/**
 *
 * @author DELL
 */
public class Testing {
    public static void main(String[] args) {
        System.out.println("Enter radius of circle: ");
        double circleRadius = Validation.inputPositiveDouble();
        System.out.println("Enter side of square: ");
        double squareSide = Validation.inputPositiveDouble();
        System.out.println("Enter 3 sides of triangle: ");
        double side1 = Validation.inputPositiveDouble();
        double side2 = Validation.inputPositiveDouble();
        double side3 = Validation.inputPositiveDouble();
        System.out.println("Enter radius of sphere: ");
        double sphereRadius = Validation.inputPositiveDouble();
        System.out.println("Enter side of cube: ");
        double cubeSize = Validation.inputPositiveDouble();
        System.out.println("Enter side of tetrahedron: ");
        double tetraSize = Validation.inputPositiveDouble();
        Shape[] shapes = new Shape[]{new Circle(circleRadius), new Square(squareSide), new Triangle(side1, side2, side3), new Sphere(sphereRadius), new Cube(cubeSize), new Tetrahedron(tetraSize)};
        for (Shape s : shapes) {
            s.display();
        }
    }
}
