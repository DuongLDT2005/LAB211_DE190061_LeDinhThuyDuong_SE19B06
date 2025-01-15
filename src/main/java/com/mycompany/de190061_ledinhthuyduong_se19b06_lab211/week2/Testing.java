/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week2;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week2.shapecalculator.*;

/**
 *
 * @author DELL
 */
public class Testing {

    public static void main(String[] args) {
        String[] options = {
            "Develop A Computer Program",
            "Create A Program To Calculate Perimeter And Area",
            "Matrix"
        };
        Menu menu = new Menu("WEEK 2", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        doComputerPro();
                        break;
                    }
                    case 2 -> {
                        doShapeCalculator();
                        break;
                    }
                    case 3 -> {
                        
                        break;
                    }
                }
            }
        };
        menu.run();
       
    }

    public static void doComputerPro() {
        String[] options = {
            "Normal Calculator",
            "BMI Calculator"
        };
        Menu calculatorMenu = new Menu("Calculator Program", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        doCalculator();
                        break;
                    }
                    case 2 -> {
                        doBMIcalculator();
                        break;
                    }
                }
            }
        };
        calculatorMenu.run();
    }

    public static void doCalculator() {
        try {
            System.out.print("Enter number: ");
            double a = Validation.inputDouble();
            double memory = a;
            while (true) {
                System.out.print("Enter operator: ");
                String operator = Validation.inputOperator();
                if (operator.equals("=")) {
                    System.out.println("Result: " + memory);
                    return;
                } else {
                    System.out.print("Enter number: ");
                    double b = Validation.inputDouble();
                    CalculatorProgram calculator = new CalculatorProgram(a, b, operator);
//                    memory = calculator.calculate(memory, b, operator);
                    memory = calculator.calculate(a, Operator.getOp(operator), b);
                    System.out.println("Memory: " + memory);
                }
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doBMIcalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = Validation.inputDouble();
        System.out.print("Enter Height(cm): ");
        double height = Validation.inputDouble();
        CalculatorProgram calculator = new CalculatorProgram(weight, height);
        double bmi = calculator.calculateBMI(weight, height);
        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + calculator.showStatusBMI(bmi));
    }
    
    public static void doShapeCalculator() {
        System.out.println("==== Calculator Shape Program ====");
        System.out.println("Please input side width of Rectangle:");
        double width = Validation.inputDouble();
        System.out.println("Please input length of Rectangle:");
        double length = Validation.inputDouble();
        Shape rectangle = new Rectangle(width, length);
        System.out.println("Please input radius of Circle:");
        double radius = Validation.inputDouble();
        Shape circle = new Circle(radius);
        System.out.println("Please input side A of Triangle:");
        double sideA = Validation.inputDouble();
        System.out.println("Please input side B of Triangle:");
        double sideB = Validation.inputDouble();
        System.out.println("Please input side C of Triangle:");
        double sideC = Validation.inputDouble();
        Shape triangle = new Triangle(sideA, sideB, sideC);
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}