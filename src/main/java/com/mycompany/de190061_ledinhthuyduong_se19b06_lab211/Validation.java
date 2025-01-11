/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.isBlank()) {
                System.out.println("Input must not be empty! Please enter again!");
            } else {
                return input;
            }
        }
    }

    public static int inputPositiveInteger() {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Input must be positive! Please enter again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format! Please enter again!");
            }
        }
    }

    public static int inputIntegerInRange(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Input must be in range (" + min + ", " + max + ")! Please enter again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format! Please enter again!");
            }
        }
    }
    
    public static String inputBinary() {
        while (true) {
                String input = inputString();
            if (input.matches("[01]+")) {
                return input;
            } else {
                System.out.println("Input must contains 0 and 1! Please enter again!");
            }
        }
    }
    
    public static String inputHexadecimal() {
        while (true) {
            String input = inputString();
            if (input.matches("[0-9A-Fa-f]+")) {
                return input;
            } else {
                System.out.println("Input must contain 0-9, A-F, or a-f! Please enter again!");
            }
        }
    }
    
    public static float inputFloat() {
        while (true) {
            try {
                float input = Float.parseFloat(inputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid double format! Please enter again!");
            }
        }
    }
}
