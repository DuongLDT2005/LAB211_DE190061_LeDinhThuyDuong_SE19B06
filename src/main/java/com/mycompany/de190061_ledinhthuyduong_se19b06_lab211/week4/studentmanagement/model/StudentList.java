/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

/**
 *
 * @author DELL
 */
public class StudentList {

    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public boolean checkStudent(Student s) {
        for (Student student : students) {
            if (student.equals(s)) return false;
        }
        return true;
    }

    public ArrayList<Student> findStudent(Predicate<Student> p, ArrayList<Student> students) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student s : students) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        Collections.sort(results);
        return results;
    }

    public void sortStudent(ArrayList<Student> list) {
        Collections.sort(list);
    }

    public void deleteStudent(ArrayList<Student> list) {
        students.removeAll(list);
    }

}
