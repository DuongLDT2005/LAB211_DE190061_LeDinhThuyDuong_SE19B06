/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.model;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ContactList {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public boolean deleteContact(int id) {
        for (Contact c : contacts) {
            if (c.getId() == id) {
                contacts.remove(c);
                updateContactIds();
                return true;
            }
        }
        return false;
    }

    private void updateContactIds() {
        int newId = 1;
        for (Contact c : contacts) {
            c.setId(newId);
            newId++;
        }
    }
}
