/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.view.CountryListView;

/**
 *
 * @author DELL
 */
public class GeographicManagement {

    public static void main(String[] args) {
        CountryListView countryLV = new CountryListView();
        String[] options = {
            "Input the information of 11 countries in East Asia",
            "Display the information of country you've just input",
            "Search the information of country by user-entered name",
            "Display the information of countries sorted name in ascending order"
        };
        Menu menu = new Menu("Menu", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        countryLV.addCountry();
                        break;
                    }
                    case 2 -> {
                        countryLV.displayRecentInput();
                        break;
                    }
                    case 3 -> {
                        countryLV.searchCountry();
                        break;
                    }
                    case 4 -> {
                        countryLV.sortCountryList();
                        break;
                    }
                }
            }
            
        };
        menu.run();
    }
}
