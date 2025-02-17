/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.view.StudentListView;

/**
 *
 * @author DELL
 */
public class StudentManagement {
    public static void main(String[] args) {
        StudentListView studentLV = new StudentListView();
        String[] options = {
            "Create",
            "Find and Sort",
            "Update/Delete",
            "Report",
            "Exit"
        };
        Menu menu = new Menu("WELCOME TO STUDENT MANAGEMENT", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        studentLV.create();
                        break;
                    }
                    case 2 -> {
                        studentLV.findAndSort();
                        break;
                    }
                    case 3 -> {
                        studentLV.updateOrDelete();
                        break;
                    }
                    case 4 -> {
                        studentLV.report();
                        break;
                    }
                    case 5 -> {
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
}
