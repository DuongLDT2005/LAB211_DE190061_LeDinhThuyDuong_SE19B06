/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.model.Contact;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.model.ContactList;

/**
 *
 * @author DELL
 */
public class ContactListView {
    private ContactList contactList = new ContactList();
    public void addContact() {
        System.out.println("--------- Add a Contact ---------");
        System.out.print("Enter First Name: ");
        String firstName = Validation.inputString();
        System.out.print("Enter Last Name: ");
        String lastName = Validation.inputString();
        System.out.print("Enter Group: ");
        String group = Validation.inputString();
        System.out.print("Enter Address: ");
        String address = Validation.inputString();
        System.out.print("Enter Phone: ");
        String phone = Validation.inputPhoneFormat();
        Contact contact = new Contact(firstName + " " + lastName, group, address, phone);
        contactList.addContact(contact);
        System.out.println("Successful");
    }
    public void deleteContact() {
        System.out.println("--------- Delete a Contact ---------");
        System.out.print("Enter ID: ");
        int id = Validation.inputPositiveInteger();
        if (contactList.deleteContact(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("ID not found");
        }
    }
    public void display() {
        System.out.println("--------- Display all Contact ---------");
        System.out.printf("%-7s %-25s %-15s %-15s %-10s %-15s %-15s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact c : contactList.getContacts()) {
            System.out.println(c);
        }
    }
}
