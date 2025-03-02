/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.view.WorkerListView;

/**
 *
 * @author DELL
 */
public class WorkerManagement {
    public static void main(String[] args) {
        WorkerListView workerLV = new WorkerListView();
        String[] options = {
            "Add Worker",
            "Up salary",
            "Down salary",
            "Display Information salary"
        };
        Menu menu = new Menu("========= Worker Management =========", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        workerLV.addWorker();
                        break;
                    }
                    case 2 -> {
                        workerLV.adjustSalary(n);
                        break;
                    }
                    case 3 -> {
                        workerLV.adjustSalary(n);
                        break;
                    }
                    case 4 -> {
                        workerLV.displaySalaryInformation();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
