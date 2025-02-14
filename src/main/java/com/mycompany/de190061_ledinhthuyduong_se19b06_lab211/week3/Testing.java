/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week3;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;

/**
 *
 * @author DELL
 */
public class Testing {

    public static void main(String[] args) {
        String[] options = {
            "Bubble Sort Algorithm",
            "Quick Sort Algorithm",
            "Binary Search Algorithm",
            "Stacks"
        };
        Menu menu = new Menu("Week 3", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        doBubbleSort();
                        break;
                    }
                    case 2 -> {
                        doQuickSort();
                        break;
                    }
                    case 3 -> {
                        doBinarySearch();
                        break;
                    }
                    case 4 -> {
                        doStack();
                    }
                }
            }
        };
        menu.run();
    }
    
    public static void doBubbleSort() {
        System.out.println("Enter number of array:");
        int n = Validation.inputIntegerGreaterThanANumber(2);
        Array arr = new Array(n);
        arr.addValue();
        System.out.println("Unsorted array: ");
        arr.displayArray();
        arr.bubbleSort();
        System.out.println("Sorted array: ");
        arr.displayArray();
    }
    
    public static void doQuickSort() {
        System.out.println("Enter number of array:");
        int n = Validation.inputIntegerGreaterThanANumber(2);
        Array arr = new Array(n);
        arr.addValue();
        System.out.println("Unsorted array:");
        arr.displayArray();
        System.out.println("Sorted array");
        arr.quickSort(arr.getArr(), 0, n - 1);
        arr.displayArray();
    }
    
    public static void doBinarySearch() {
        System.out.println("Enter a number of array:");
        int n = Validation.inputPositiveInteger();
        System.out.println("Enter search value:");
        int searchValue = Validation.inputPositiveInteger();
        Array arr = new Array(n);
        arr.addValue();
        System.out.println("Unsorted array:");
        arr.displayArray();
        System.out.println("Sorted array:");
        arr.bubbleSort();
        arr.displayArray();
        int index = arr.searchValue(searchValue);
        if (index == -1) {
            System.out.println("Not found " + searchValue);
        } else {
                    System.out.println("Found " + searchValue + " at index: " + index);

        }
    }
    
    public static void doStack() {
        MyStack myStack = new MyStack();
        String[] options = {
          "Push a value to the stack",
          "Pop a value out of the stack",
          "Get a value from the stack"
        };
        Menu stackMenu = new Menu("Stack", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        System.out.println("Enter value: ");
                        int value = Validation.inputInteger();
                        myStack.push(value);
                        break;
                    }
                    case 2 -> {
                        int popValue = myStack.pop();
                        if (popValue == -1) {
                            System.out.println("Stack is empty, can not pop!");
                        } else {
                            System.out.println("Remove element: " + popValue);
                        }
                        break;
                    }
                    case 3 -> {
                        int topValue = myStack.get();
                        if (topValue == -1) {
                            System.out.println("Stack is empty, can not peek!");
                        } else {
                            System.out.println("Top value: " + topValue);
                        }
                    }
                }
            }
        };
        stackMenu.run();
    }
}
