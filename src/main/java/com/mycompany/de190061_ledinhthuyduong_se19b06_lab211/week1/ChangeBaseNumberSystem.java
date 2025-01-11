/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week1;

/**
 *
 * @author DELL
 */
public class ChangeBaseNumberSystem {
    private int inputBase, outputBase;
    private String inputValue;

    public ChangeBaseNumberSystem(int inputBase, int outputBase, String inputValue) {
        this.inputBase = inputBase;
        this.outputBase = outputBase;
        this.inputValue = inputValue;
    }

    public String convertToBinary(String input, int base) {
        switch (base) {
            case 1 -> {
                return input;
            }
            case 2 -> {
                StringBuilder sb = new StringBuilder();
                int decimalValue = Integer.parseInt(input);
                if (decimalValue == 0) {
                    return "0";
                }
                while (decimalValue > 0) {
                    int remainder = decimalValue % 2;
                    sb.append(Integer.toString(remainder));
                    decimalValue /= 2;
                }
                return sb.reverse().toString();
            }
            case 3 -> {
                String decNumber = convertToDecimal(input, 3);
                return convertToBinary(decNumber, 2);
            }
            default -> {
                System.out.println("Wrong input");
                return null;
            }
        }
    }

    public String convertToDecimal(String input, int base) {
        switch (base) {
            case 1 -> {
                int decimalValue = 0;
                for (int i = input.length() - 1; i >= 0; i--) {
                    char digit = input.charAt(i);
                    int digitValue = 0;
                    if (digit == '1') {
                        digitValue = 1;
                    } else if (digit == '0') {
                        digitValue = 0;
                    } else {
                        System.out.println("Wrong input");
                        return null;
                    }
                    decimalValue += digitValue * Math.pow(2, input.length() - 1 - i);
                }
                return Integer.toString(decimalValue);
            }
            case 2 -> {
                return input;
            }
            case 3 -> {
                int decimalValue = 0;
                for (int i = input.length() - 1; i >= 0; i--) {
                    char digit = input.charAt(i);
                    int digitValue;
                    if (digit >= '0' && digit <= '9') {
                        digitValue = digit - '0';
                    } else if (digit >= 'A' && digit <= 'F') {
                        digitValue = digit - 'A' + 10;
                    } else {
                        System.out.println("Wrong input");
                        return null;
                    }
                    decimalValue += digitValue * Math.pow(16, input.length() - 1 - i);
                }
                return Integer.toString(decimalValue);
            }
            default -> {
                System.out.println("Wrong input");
                return null;
            }
        }
    }

    public String convertToHexa(String input, int base) {
        switch (base) {
            case 1 -> {
                String decNumber = convertToDecimal(input, 1);
                return convertToHexa(decNumber, 2);
            }
            case 2 -> {
                StringBuilder sb = new StringBuilder();
                int decimalValue = Integer.parseInt(input);
                if (decimalValue == 0) {
                    return "0";
                }
                while (decimalValue > 0) {
                    int remainder = decimalValue % 16;
                    if (remainder < 10) {
                        sb.append(Integer.toString(remainder));
                    } else {
                        sb.append((char)(remainder - 10 + 'A'));
                    }
                    decimalValue /= 16;
                }
                return sb.reverse().toString();
            }
            case 3 -> {
                return input;
            }
            default -> {
                System.out.println("Wrong input");
                return null;
            }
        }
    }

    public void displayResult() {
        switch (outputBase) {
            case 1 -> {
                System.out.println("Binary: " + convertToBinary(inputValue, inputBase));
                break;
            }
            case 2 -> {
                System.out.println("Decimal: " + convertToDecimal(inputValue, inputBase));
                break;
            }
            case 3 -> {
                System.out.println("Hexadecimal: " + convertToHexa(inputValue, inputBase));
                break;
            }
        }
    }
}
