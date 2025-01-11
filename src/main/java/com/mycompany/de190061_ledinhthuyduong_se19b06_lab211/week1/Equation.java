/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Equation {

    private float a, b, c;

    public Equation(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public Equation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public List<Float> calculateSuperlativeEquation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                return new ArrayList<>();
            } else {
                return null;
            }
        } else {
            List<Float> result = new ArrayList<>();
            result.add(-b / a);
            return result;
        }
    }

    public List<Float> calculateQuadraticEquation() {
        if (a == 0) {
            return calculateSuperlativeEquation(b, c);
        }
        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            return null;
        } else if (delta == 0) {
            List<Float> result = new ArrayList<>();
            result.add(-b / (2 * a));
            return result;
        } else {
            float x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            List<Float> result = new ArrayList<>();
            result.add(x1);
            result.add(x2);
            return result;
        }
    }

    public void checkCoefficents(float[] coefficients) {
        ArrayList<Float> evenNumber = new ArrayList<>();
        ArrayList<Float> oddNumber = new ArrayList<>();
        ArrayList<Float> squareNumber = new ArrayList<>();
        for (float x : coefficients) {
            if (isOdd(x)) {
                oddNumber.add(x);
            } else {
                evenNumber.add(x);
            }
            if (isPerfectSquareNumber(x)) {
                squareNumber.add(x);
            }
        }
        if (!evenNumber.isEmpty()) {
            System.out.println("Even number(s): " + evenNumber);
        }
        if (!oddNumber.isEmpty()) {
            System.out.println("Odd number(s): " + oddNumber);
        }
        if (!squareNumber.isEmpty()) {
            System.out.println("Perfect square number(s): " + squareNumber);
        }
    }

    public boolean isOdd(float x) {
        return x % 2 != 0;
    }

    public boolean isPerfectSquareNumber(float x) {
        if (x < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(x);
        return (sqrt * sqrt) == x;
    }

    public void displayResult(int choice) {
        switch (choice) {
            case 1 -> {
                List<Float> resultList = calculateSuperlativeEquation(a, b);
                if (resultList == null) {
                    System.out.println("No solution");
                } else if (resultList.isEmpty()) {
                    System.out.println("Infinitely many solutions");
                } else {
                    System.out.println("Solution: x = " + resultList.get(0));
                }
                break;
            }
            case 2 -> {
                List<Float> resultList = calculateQuadraticEquation();
                if (resultList == null) {
                    System.out.println("No solution");
                } else if (resultList.isEmpty()) {
                    System.out.println("Infinitely many solutions");
                } else if (resultList.size() == 1) {
                    System.out.println("Solution: x = " + resultList.get(0));
                } else {
                    System.out.println("Solution: x1 = " + resultList.get(0) + ", x2 = " + resultList.get(1));
                }
                break;
            }
        }
    }
}
