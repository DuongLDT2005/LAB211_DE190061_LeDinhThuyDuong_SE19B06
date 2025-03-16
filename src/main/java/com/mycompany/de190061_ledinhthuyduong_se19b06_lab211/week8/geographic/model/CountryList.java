/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week8.geographic.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class CountryList {
    private ArrayList<EastAsiaCountries> countries = new ArrayList<>();

    public ArrayList<EastAsiaCountries> getCountries() {
        return countries;
    }
    public void addCountries(EastAsiaCountries country) {
        countries.add(country);
    }
    public EastAsiaCountries searchCountry(String name) {
        for (EastAsiaCountries c : countries) {
            if (c.getCountryName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
    public void sortCountriesByName() {
        Collections.sort(countries);
    }
}
