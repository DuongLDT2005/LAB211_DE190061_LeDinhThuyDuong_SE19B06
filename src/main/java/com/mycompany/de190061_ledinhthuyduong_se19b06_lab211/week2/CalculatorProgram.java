/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week2;


/**
 *
 * @author DELL
 */
public class CalculatorProgram {

    private double a, b;
    private String operator;
    private double weight, height;

    public CalculatorProgram(double a, double b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public CalculatorProgram(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

//    public double calculate(double a, double b, String operator) {
//        switch (operator) {
//            case "+" -> {
//                return a + b;
//            }
//            case "-" -> {
//                return a - b;
//            }
//            case "*" -> {
//                return a * b;
//            }
//            case "/" -> {
//                if (b == 0) {
//                    throw new ArithmeticException("Cannot divide by 0");
//                } else {
//                    return a / b;
//                }
//            }
//            case "^" -> {
//                return Math.pow(a, b);
//            }
//            default -> {
//                return -1;
//            }
//        }
//    }
    
    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD -> {
                return a + b;
            }
            case SUBTRACT -> {
                return a - b;
            }
            case MULTIPLY -> {
                return a * b;
            }
            case DIVIDE -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by 0");
                } else {
                    return a / b;
                }
            }
            case POWER -> {
                return Math.pow(a, b);
            }
            default -> {
                throw new IllegalArgumentException("Exception: " + operator);
            }
        }
    }

    public double calculateBMI(double weight, double height) {
        return weight * 10000 / (height * height);
    }

    public String showStatusBMI(double bmi) {
        if (bmi < 19) {
            return "UNDER-STANDARD";
        } else if (bmi < 25) {
            return "STANDARD";
        } else if (bmi < 30) {
            return "OVERWEIGHT";
        } else if (bmi < 40) {
            return "FAT - Should lose weight";
        } else {
            return "VERY FAT - Should lose weight immediately";
        }
    }
}
