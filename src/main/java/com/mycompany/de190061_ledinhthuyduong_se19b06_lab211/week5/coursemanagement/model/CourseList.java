/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author DELL
 */
public class CourseList {

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course searchCourse(Predicate<Course> p) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (p.test(c)) {
                return c;
            }
        }
        return null;
    }
    
    public void deleteCourse(Course course) {
        courses.remove(course);
    }
 
}
