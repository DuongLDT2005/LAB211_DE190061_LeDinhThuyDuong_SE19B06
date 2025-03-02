/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week6.contactmanagementprogram.view.ContactListView;

/**
 *
 * @author DELL
 */
public class ContactManagement {
    public static void main(String[] args) {
        ContactListView contactLV = new ContactListView();
        String[] options = {
          "Add a Contact",
            "Display all Contact",
            "Delete a Contact"
        };
        Menu menu = new Menu("========= Contact program =========", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        contactLV.addContact();
                        break;
                    }
                    case 2 -> {
                        contactLV.display();
                        break;
                    }
                    case 3 -> {
                        contactLV.deleteContact();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
