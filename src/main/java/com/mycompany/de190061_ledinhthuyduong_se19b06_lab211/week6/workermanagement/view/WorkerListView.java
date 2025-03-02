/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.model.SalaryHistory;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.model.Worker;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.model.WorkerList;

/**
 *
 * @author DELL
 */
public class WorkerListView {

    private WorkerList workerList = new WorkerList();

    public void addWorker() {
        System.out.println("--------- Add Worker ---------");
        System.out.print("Enter Code: ");
        String id = Validation.inputString();
        System.out.print("Enter Name: ");
        String name = Validation.inputString();
        System.out.print("Enter Age: ");
        int age = Validation.inputIntegerInRange(18, 50);
        System.out.print("Enter Salary: ");
        double salary = Validation.inputPositiveDouble();
        System.out.print("Enter work location: ");
        String workLocation = Validation.inputString();
        Worker worker = new Worker(id, name, workLocation, age, salary);
        if (workerList.addWorker(worker)) {
            System.out.println("Add successfully!");
        } else {
            System.out.println("Duplicated ID! Skipping...");
        }
    }

    public void adjustSalary(int choice) {
        System.out.println("--------- Up/Down Salary ---------");
        System.out.print("Enter Code: ");
        String id = Validation.inputString();
        System.out.print("Enter Salary: ");
        double salary = Validation.inputPositiveDouble();
        if (choice == 2) {
            if (!workerList.changeSalary("UP", id, salary)) {
                System.out.println("ID not found");
            }
        } else {
            if (!workerList.changeSalary("DOWN", id, salary)) {
                System.out.println("ID not found!");
            }
        }
    }
    public void displaySalaryInformation() {
        System.out.println("--------- Display Information Salary ---------");
        System.out.printf("%-10s %-20s %-10s %-17s %-15s %-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (Worker w : workerList.getWorkers()) {
            for (SalaryHistory s : w.getSalaryHistory()) {
                System.out.println(w.toString() + s.toString());
            }
        }    
    }
}
