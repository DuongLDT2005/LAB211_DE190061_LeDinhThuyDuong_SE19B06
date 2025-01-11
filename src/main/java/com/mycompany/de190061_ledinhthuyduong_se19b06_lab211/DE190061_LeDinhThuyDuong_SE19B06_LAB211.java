/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week1.*;

/**
 *
 * @author DELL
 */
public class DE190061_LeDinhThuyDuong_SE19B06_LAB211 {

    public static void main(String[] args) {
        String[] options = {
            "Linear Search",
            "Letter And Character Count",
            "Change Base Number System",
            "Solving The Equatin, Find The Square Number, Even Number And Odd Number"
        };
        Menu menu = new Menu("EXCERSISE", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        System.out.println("Enter number of array:");
                        int size = Validation.inputPositiveInteger();
                        System.out.println("Enter search value:");
                        int searchNumber = Validation.inputPositiveInteger();
                        LinearSearch linearSearch = new LinearSearch(size);
                        linearSearch.addValue();
                        linearSearch.showArray();
                        int index = linearSearch.searchValue(searchNumber);
                        if (index == -1) {
                            System.out.println("Not found " + searchNumber + " in the array");
                        } else {
                            System.out.println("Found " + searchNumber + " at index: " + index);
                        }
                        break;
                    }
                    case 2 -> {
                        System.out.println("Enter your content:");
                        String str = Validation.inputString();
                        LetterAndCharaterCount count = new LetterAndCharaterCount(str);
                        System.out.println(count.countWord());
                        System.out.println(count.countCharater());
                        break;
                    }
                    case 3 -> {
                        System.out.println("Choose the input base system:");
                        System.out.println("1. Binary");
                        System.out.println("2. Decimal");
                        System.out.println("3. Hexadecimal");
                        System.out.println("Enter your choice:");
                        int inputBase = Validation.inputIntegerInRange(1, 3);
                        System.out.println("Choose the output base system:");
                        System.out.println("1. Binary");
                        System.out.println("2. Decimal");
                        System.out.println("3. Hexadecimal");
                        System.out.println("Enter your choice:");
                        int outputBase = Validation.inputIntegerInRange(1, 3);
                        System.out.println("Enter the input value:");
                        String inputValue = Validation.inputString();
                        ChangeBaseNumberSystem changeBaseNumber = new ChangeBaseNumberSystem(inputBase, outputBase, inputValue);
                        changeBaseNumber.displayResult();
                        break;
                    }
                    case 4 -> {
                        String[] choices = {
                            "Calculate Superlative Equation",
                            "Calculate Quadratic Equation",
                        };
                        Menu calculationMenu = new Menu("Program", choices) {
                            @Override
                            public void execute(int n) {
                                switch (n) {
                                    case 1 -> {
                                        System.out.println("Please enter coefficents A, B!");
                                        float a = Validation.inputFloat();
                                        float b = Validation.inputFloat();
                                        Equation equation = new Equation(a, b);
                                        equation.displayResult(n);
                                        equation.checkCoefficents(new float[]{a, b});
                                        break;
                                    }
                                    case 2 -> {
                                        System.out.println("Please enter coefficients A, B, C!");
                                        float a = Validation.inputFloat();
                                        float b = Validation.inputFloat();
                                        float c = Validation.inputFloat();
                                        Equation equation = new Equation(a, b, c);
                                        equation.displayResult(n);
                                        equation.checkCoefficents(new float[]{a, b, c});
                                        break;
                                    }
                                }
                            }
                        };
                        calculationMenu.run();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
