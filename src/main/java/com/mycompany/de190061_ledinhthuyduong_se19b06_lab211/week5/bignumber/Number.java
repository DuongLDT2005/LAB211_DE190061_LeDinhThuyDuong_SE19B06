/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.bignumber;

/**
 *
 * @author DELL
 */
public class Number {
    private int[] a, b;

    public Number(String num1, String num2) {
        this.a = new int[num1.length()];
        this.b = new int[num2.length()];
    }
    
    public void convertToArrayOfDigits(String num1, String num2) {
        for (int i = 0; i < this.a.length; i++) {
            this.a[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < this.b.length; i++) {
            this.b[i] = num2.charAt(i) - '0';
        }
    }
    
    public int[] add() {
        int maxLength = Math.max(this.a.length, this.b.length);
        int[] result = new int[maxLength + 1];
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int digit1 = 0, digit2 = 0;
            if (i < this.a.length) digit1 = this.a[this.a.length - 1 - i];
            if (i < this.b.length) digit2 = this.b[this.b.length - 1 - i];
            int sum = digit1 + digit2 + carry;
            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) result[0] = carry;
        return result;
    }
    
    public int[] multiply() {
        int[] result = new int[this.a.length + this.b.length];
        for (int i = this.a.length - 1; i >= 0; i--) {
            for (int j = this.b.length - 1; j >= 0; j--) {
                int product = this.a[i] * this.b[j];
                int resultPosition = i + j + 1;
                int sum = product + result[resultPosition];
                result[resultPosition] = sum % 10;
                int carry = sum / 10;
                result[resultPosition - 1] += carry;
            }
        }
        return result;
    }
    
    public void display(int[] result) {
        boolean leadingZero = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 || !leadingZero) {
                System.out.print(result[i]);
                leadingZero = false;
            }
        }
    }
}
