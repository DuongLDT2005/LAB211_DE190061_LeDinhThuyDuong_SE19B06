/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.model.FlightInformation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.model.Reservation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.roommanagement.model.ReservationList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ReservationListView {

    private ReservationList reservationList = new ReservationList();

    private boolean isUniqueID(String id) {
        for (Reservation r : reservationList.getReservations()) {
            if (r.getBookingID().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public void createReservation() {
        System.out.println("*** Create new reservation ***");
        String reservationID;
        while (true) {
            System.out.print("ID: ");
            reservationID = Validation.inputDigitStringWithLength(6);
            if (!isUniqueID(reservationID)) {
                System.out.println("Data input is invalid! ID must be unique!");
            } else {
                break;
            }
        }
        System.out.print("Name: ");
        String customerName = Validation.inputAlphabetStringWithBlank();
        System.out.print("Phone: ");
        String phoneNumber = Validation.inputDigitStringWithLength(12);
        System.out.print("RoomNumbers: ");
        String roomNumber = Validation.inputDigitStringWithLength(4);
        System.out.print("BookingDate: ");
        Date bookingDate = Validation.inputDateFormatInFuture();
        System.out.print("Need airport picl up? (Y/N): ");
        String needPickUp = Validation.inputStringInFormat(new String[]{"Y", "N"});
        if (needPickUp.equalsIgnoreCase("N")) {
            Reservation reservation = new Reservation(reservationID, customerName, phoneNumber, roomNumber, bookingDate, null);
            reservationList.addReservation(reservation);
        } else {
            System.out.print("Flight: ");
            String flight = Validation.inputString();
            System.out.print("Seat: ");
            String seat = Validation.inputString();
            System.out.print("TimePickUp: ");
            Date timePickUp = Validation.inputTime(bookingDate);
            FlightInformation flightInfor = new FlightInformation(flight, seat, timePickUp);
            Reservation reservation = new Reservation(reservationID, customerName, phoneNumber, roomNumber, bookingDate, flightInfor);
            reservationList.addReservation(reservation);
        }
        System.out.println("Information saved successfully!");
    }

    private boolean isContinueToFind() {
        System.out.print("No data found, do you want to find again? (Y/N): ");
        return Validation.inputStringInFormat(new String[]{"Y", "N"}).equalsIgnoreCase("Y");
    }

    private Reservation findReservationByID() {
        while (true) {
            System.out.print("ID: ");
            String id = Validation.inputString();
            Reservation r = reservationList.searchReservation(reservation -> reservation.getBookingID().equals(id));
            if (r != null || !isContinueToFind()) {
                return r;
            }
        }
    }

    private void displayOneReservation(Reservation r) {
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        System.out.println(r);
    }

    public void updateReservation() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        System.out.println("*** Update reservation ***");
        Reservation r = findReservationByID();
        if (r == null) {
            return;
        }
        displayOneReservation(r);
        System.out.println("If you do not want to change the information, just press enter to skip.");
        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!name.isBlank() && name.matches("[a-zA-Z\\s]+")) {
            r.setCustomerName(name);
        }
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        if (!phone.isBlank() && phone.matches("\\d{12}")) {
            r.setPhoneNumber(phone);
        }
        System.out.print("RoomNumbers: ");
        String roomNumber = sc.nextLine();
        if (!roomNumber.isBlank() && phone.matches("\\d{4}")) {
            r.setRoomNumber(roomNumber);
        }
        System.out.print("BookingDate: ");
        String bookingDateStr = sc.nextLine();
        Date bookingDate = null;
        if (!bookingDateStr.isBlank()) {
            try {
                bookingDate = sdf.parse(bookingDateStr);
                if (bookingDate.after(new Date())) {
                    r.setBookingDate(bookingDate);
                }
            } catch (ParseException e) {
                System.out.println("Skip invalid input!");
            }
        }
        System.out.print("Need airport pick up? (Y/N): ");
        String needPickup = sc.nextLine();
        if (needPickup.equalsIgnoreCase("N")) {
            r.setFlightInformation(null);
        }
        if (needPickup.equalsIgnoreCase("Y")) {
            if (r.getFlightInformation() == null) r.setFlightInformation(new FlightInformation());
            System.out.print("Flight: ");
            String flight = sc.nextLine();
            if (!flight.isBlank()) {
                r.getFlightInformation().setFlightNumber(flight);
            }
            System.out.print("Seat: ");
            String seat = sc.nextLine();
            if (!seat.isBlank()) {
                r.getFlightInformation().setSeatNumber(seat);
            }
            System.out.print("TimePickUp: ");
            String timePickUpStr = sc.nextLine();
            if (!timePickUpStr.isBlank()) {
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mma");
                    format.setLenient(false);
                    Date timePickUp = format.parse(timePickUpStr);
                    if (timePickUp.after(new Date()) && timePickUp.before(bookingDate)) {
                        r.getFlightInformation().setTimePickUp(timePickUp);
                    }
                } catch (ParseException e) {
                    System.out.println("Skip invalid input!");
                }
            }
        }
        displayOneReservation(r);
        System.out.println("Information saved successfully!");
    }

    public void deleteReservation() {
        System.out.println("*** Delete reservation ***");
        Reservation r = findReservationByID();
        if (r == null) {
            return;
        }
        displayOneReservation(r);
        System.out.print("Are you sure you want to delete this information? (Y/N): ");
        String choice = Validation.inputStringInFormat(new String[]{"Y", "N"});
        if (choice.equalsIgnoreCase("Y")) {
            reservationList.deleteReservation(r);
            System.out.println("Delete successfully!");
        }
    }

    public void printFlightInformation() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mma");
        System.out.println("*** Flight Information ***");
        if (reservationList.getReservations().isEmpty()) {
            System.out.println("No information to view!");
            return;
        }
        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
        boolean check = false;
        for (Reservation r : reservationList.getReservations()) {
            if (r.getFlightInformation() != null) {
                System.out.println(r.getBookingID() + " - " + r.getCustomerName() + " - " +
                    r.getPhoneNumber() + " - " + r.getFlightInformation().getFlightNumber() + " - " +
                    r.getFlightInformation().getSeatNumber() + " - " + sdf.format(r.getFlightInformation().getTimePickUp()));
                check = true;
            }
        }
        if (!check) System.out.println("No information to view!");
    }

    public void printAll() {
        System.out.println("*** Reservation Information ***");
        if (reservationList.getReservations().isEmpty()) {
            System.out.println("No information to view!");
            return;
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        for (Reservation r : reservationList.getReservations()) {
            System.out.println(r);
        }
    }
}
