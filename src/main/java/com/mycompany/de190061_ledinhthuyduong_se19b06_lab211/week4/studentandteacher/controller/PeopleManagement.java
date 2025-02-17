/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.view.PersonListView;

/**
 *
 * @author DELL
 */
public class PeopleManagement {

    private static PersonListView personLV = new PersonListView();

    public static void main(String[] args) {
        String[] options = {
            "Teacher",
            "Student",
            "Person"
        };
        Menu menu = new Menu("Information Management", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        doPersonManagement(n, "Teacher Managemnet");
                        break;
                    }
                    case 2 -> {
                        doPersonManagement(n, "Student Management");
                        break;
                    }
                    case 3 -> {
                        doPersonManagement(n, "Person Management");
                        break;
                    }
                }
            }
        };
        menu.run();
    }

    public static void doPersonManagement(int choice, String str) {
        String[] options;
        if (choice == 3) {
            options = new String[]{"Search", "Print all"};
        } else {
            options = new String[]{"Input", "Print"};
        }
        Menu miniMenu = new Menu(str, options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        if (choice == 3) {
                            personLV.searchPerson();
                        } else {
                            personLV.inputAll(choice);
                        }
                        break;
                    }
                    case 2 -> {
                        personLV.displayAll(choice);
                        break;
                    }
                }
            }
        };
        miniMenu.run();
    }
}
