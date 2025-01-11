/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week1;

import java.util.Random;

/**
 *
 * @author DELL
 */
public class LinearSearch {

    private int[] array;

    public LinearSearch(int n) {
        this.array = new int[n];
    }

    public void addValue() {
        //add value into array
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }

    public void showArray() {
        //print all value of array
        System.out.print("The array: ");
        for (int i = 0; i < array.length; i++) {
            if (i == (array.length - 1)) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println();
    }

    public int searchValue(int x) {
        //search and return index
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
