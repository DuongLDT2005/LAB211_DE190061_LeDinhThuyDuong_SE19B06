/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author DELL
 */
public class ReservationList {
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public void addReservation(Reservation r) {
        reservations.add(r);
    }
    public Reservation searchReservation(Predicate<Reservation> p) {
        for (Reservation r : reservations) {
            if (p.test(r)) return r;
        }
        return null;
    }
    
    public void deleteReservation(Reservation r) {
        reservations.remove(r);
    }
}
