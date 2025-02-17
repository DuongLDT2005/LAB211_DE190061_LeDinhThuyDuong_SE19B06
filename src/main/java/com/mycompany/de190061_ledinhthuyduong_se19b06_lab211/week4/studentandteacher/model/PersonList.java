/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author DELL
 */
public class PersonList {

    private ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Person> getpeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void sortPeople(int choice, ArrayList<Person> list) {
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                switch (choice) {
                    case 1 -> {
                            Teacher t1 = (Teacher) o1;
                            Teacher t2 = (Teacher) o2;
                            return Integer.compare(t2.getProfessionYear(), t1.getProfessionYear());
                    }
                    case 2 -> {
                            Student s1 = (Student) o1;
                            Student s2 = (Student) o2;
                            return Integer.compare(s1.getAdmissionYear(), s2.getAdmissionYear()); 
                    }
                    case 3 -> {
                        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
                    }
                }
                return -1;
            }
        });
    }
    
    public ArrayList<Person> searchPeople(Predicate<Person> p) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (p.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
