/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.view.ReservationListView;

/**
 *
 * @author DELL
 */
public class ReservationManagement {
    public static void main(String[] args) {
        ReservationListView rlv =new ReservationListView();
        String[] options = {
            "Create new reservation",
            "Update reservation",
            "Delete reservation",
            "Print Flight Information",
            "Print all"
        };
        Menu menu = new Menu("*** Reservation Management ***", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        rlv.createReservation();
                        break;
                    }
                    case 2 -> {
                        rlv.updateReservation();
                        break;
                    }
                    case 3 -> {
                        rlv.deleteReservation();
                        break;
                    }
                    case 4 -> {
                        rlv.printFlightInformation();
                        break;
                    }
                    case 5 -> {
                        rlv.printAll();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
