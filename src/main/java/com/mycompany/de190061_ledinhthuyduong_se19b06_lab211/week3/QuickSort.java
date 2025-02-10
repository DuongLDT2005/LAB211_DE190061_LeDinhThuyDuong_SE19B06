/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week3;

import java.util.Random;

/**
 *
 * @author DELL
 */
public class QuickSort {

    private int[] arr;

    public QuickSort(int n) {
        this.arr = new int[n];
    }

    public void addValue() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
    }

    public void displayArray() {
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    public void quickSort(int head, int tail) {
        if (head >= tail) {
            return;
        }
        int pivot = arr[(head + tail) / 2];
        int i = head, j = tail;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(head, j);
        quickSort(i, tail);
    }
}
