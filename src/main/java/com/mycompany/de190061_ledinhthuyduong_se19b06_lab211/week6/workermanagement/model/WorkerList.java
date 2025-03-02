/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.workermanagement.model;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class WorkerList {

    private ArrayList<Worker> workers = new ArrayList<>();

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public boolean addWorker(Worker worker) {
        for (Worker w : workers) {
            if (w.getId().equals(worker.getId())) {
                return false;
            }
        }
        workers.add(worker);
        return true;
    }

    public boolean changeSalary(String status, String id, double amount) {
        Worker updateWorker = null;
        for (Worker w : workers) {
            if (w.getId().equals(id)) {
                updateWorker = w;
            }
        }
        if (updateWorker == null) {
            return false;
        }
        if (status.equalsIgnoreCase("up")) {
            updateWorker.increaseSalary(amount);
        } else {
            updateWorker.decreaseSalary(amount);
        }
        System.out.println("Adjust successfully!");
        return true;
    }
}
