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
        if (head < tail) {
            int pivotIndex = (head + tail) / 2;
            int pivot = arr[pivotIndex];
            int partitionIndex = partition(head, tail, pivot);
            quickSort(head, partitionIndex - 1);
            quickSort(partitionIndex, tail);
        }
    }

    public int partition(int head, int tail, int pivot) {
        while (head <= tail) {
            while (arr[head] < pivot) {
                head++;
            }
            while (arr[tail] > pivot) {
                tail--;
            }
            if (head <= tail) {
                int temp = arr[head];
                arr[head] = arr[tail];
                arr[tail] = temp;
                head++;
                tail--;
            }
        }
        return head;
    }
}
