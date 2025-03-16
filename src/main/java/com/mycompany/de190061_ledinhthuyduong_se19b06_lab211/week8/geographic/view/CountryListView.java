/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.model.Country;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.model.CountryList;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.model.EastAsiaCountries;

/**
 *
 * @author DELL
 */
public class CountryListView {

    private CountryList countryList = new CountryList();

    public void addCountry() {
        System.out.println("Enter code of country:");
        String countryCode = Validation.inputString();
        System.out.println("Enter name of country:");
        String countryName = Validation.inputString();
        System.out.println("Enter total area:");
        float totalArea = Validation.inputPositiveFloat();
        System.out.println("Enter terrain of country:");
        String countryTerrain = Validation.inputString();
        EastAsiaCountries country = new EastAsiaCountries(countryTerrain, countryCode, countryName, totalArea);
        countryList.addCountries(country);
    }

    public void displayRecentInput() {
        System.out.printf("%-10s %-15s %-16s %-10s\n", "ID", "Name", "Total Area", "Terrain");
        System.out.println(countryList.getCountries().getLast());
    }

    public void searchCountry() {
        System.out.println("Enter the name you want to search for:");
        String name = Validation.inputString();
        EastAsiaCountries searchCountry = countryList.searchCountry(name);
        if (searchCountry == null) {
            System.out.println("Country not found!");
            return;
        }
        System.out.printf("%-10s %-15s %-16s %-10s\n", "ID", "Name", "Total Area", "Terrain");
        System.out.println(searchCountry);
    }

    public void sortCountryList() {
        countryList.sortCountriesByName();
        System.out.printf("%-10s %-15s %-16s %-10s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country c : countryList.getCountries()) {
            System.out.println(c);
        }
    }
}
