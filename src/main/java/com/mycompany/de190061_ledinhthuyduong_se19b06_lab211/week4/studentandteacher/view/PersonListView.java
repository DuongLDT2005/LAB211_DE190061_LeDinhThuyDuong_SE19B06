/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model.Person;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model.PersonList;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model.Student;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentandteacher.model.Teacher;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PersonListView {

    private PersonList personList = new PersonList();

    public void inputAll(int choice) {
        System.out.print("ID: ");
        String id = Validation.inputDigitStringWithLength(6);
        System.out.print("Fullname: ");
        String fullname = Validation.inputAlphabetStringWithBlank();
        System.out.print("Phone number: ");
        String phoneNumber = Validation.inputDigitStringWithLength(12);
        System.out.print("Year of birth: ");
        int birthYear = Validation.inputbirthYear();
        System.out.print("Major: ");
        String major = Validation.inputStringWithLengthLessThan(30);
        if (choice == 1) {
            System.out.print("Year in the profession: ");
            int professionYear = Validation.inputIntegerInRange(0, Year.now().getValue() - birthYear - 1);
            System.out.print("Contract type: ");
            String contractType = Validation.inputStringInFormat(new String[]{"Long", "Short"});
            System.out.print("Salary coefficient: ");
            double salaryCoefficient = Validation.inputPositiveDouble();
            Person teacher = new Teacher(id, fullname, phoneNumber, birthYear, major, professionYear, contractType, salaryCoefficient);
            personList.addPerson(teacher);
        } else {
            System.out.print("Year of admission: ");
            int admissionYear = Validation.inputIntegerInRange(birthYear, Year.now().getValue());
            System.out.print("Entrance English score: ");
            int englishScore = Validation.inputIntegerInRange(0, 100);
            Person student = new Student(id, fullname, phoneNumber, birthYear, major, admissionYear, englishScore);
            personList.addPerson(student);
        }
    }

    public void displayAll(int choice) {
        if (personList.getpeople().isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        ArrayList<Person> teacherList = new ArrayList<>();
        ArrayList<Person> studentList = new ArrayList<>();
        for (Person p : personList.getpeople()) {
            if (p instanceof Teacher) {
                teacherList.add(p);
            } else if (p instanceof Student) {
                studentList.add(p);
            }
        }
        switch (choice) {
            case 1 -> {
                if (teacherList.isEmpty()) {
                    System.out.println("List is empty!");
                    return;
                }
                personList.sortPeople(1, teacherList);
                System.out.printf("%-8s | %-20s | %-17s | %-15s | %-22s | %-25s | %-15s | %-25s\n",
                        "ID", "Fullname", "Phonenumber", "Year of birth", "Major", "Year in the profession", "Contract type", "Salary coefficient");
                for (Person person : teacherList) {
                    System.out.println(person);
                }
                break;
            }
            case 2 -> {
                if (studentList.isEmpty()) {
                    System.out.println("List is empty!");
                    return;
                }
                personList.sortPeople(2, studentList);
                System.out.printf("%-8s | %-20s | %-17s | %-15s | %-22s | %-20s | %-25s\n",
                        "ID", "Fullname", "Phonenumber", "Year of birth", "Major", "Year of admission", "Entrance English score");
                for (Person person : studentList) {
                    System.out.println(person);
                }
                break;
            }
            case 3 -> {
                personList.sortPeople(3, personList.getpeople());
                System.out.printf("%-8s | %-20s | %-17s | %-15s | %-22s\n", "ID", "Fullname", "Phone number", "Year of birth", "Major");
                for (Person person : personList.getpeople()) {
                    System.out.printf("%-8s | %-20s | %-17s | %-15d | %-22s\n", person.getId(), person.getFullname(), person.getPhoneNumber(), person.getBirthYear(), person.getMajor());
                }
                break;
            }
        }
    }

    public void searchPerson() {
        System.out.print("Name: ");
        String name = Validation.inputAlphabetStringWithBlank();
        ArrayList<Person> result = personList.searchPeople(person -> person.getFullname().contains(name));
        if (result.isEmpty()) {
            System.out.println("Result: not found");
        } else {
            personList.sortPeople(3, result);
            System.out.printf("%-8s | %-20s | %-17s | %-15s | %-22s\n", "ID", "Fullname", "Phone number", "Year of birth", "Major");
            for (Person person : result) {
                System.out.println(person);
            }
        }
    }
    
}
