/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.bignumber;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import java.math.BigInteger;

/**
 *
 * @author DELL
 */
public class Testing {
    public static void main(String[] args) {
        System.out.println("Enter 1st number:");
        String num1 = Validation.inputDigitString();
        System.out.println("Enter 2st number:");
        String num2 = Validation.inputDigitString();
        Number bigNum = new Number(num1, num2);
        bigNum.convertToArrayOfDigits(num1, num2);
        System.out.println("Sum:");
        bigNum.display(bigNum.add());
        System.out.println();
        System.out.println("Multiplication:");
        bigNum.display(bigNum.multiply());
        
        BigInteger num1BI = new BigInteger(num1);
        BigInteger num2BI = new BigInteger(num2);
        System.out.println("Sum: " + num1BI.add(num2BI));
        System.out.println("Multipication: " + num1BI.multiply(num2BI));
    }
}
