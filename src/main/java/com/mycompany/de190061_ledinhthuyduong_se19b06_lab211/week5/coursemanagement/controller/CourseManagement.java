/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.view.CourseListView;

/**
 *
 * @author DELL
 */
public class CourseManagement {

    public static void main(String[] args) {
        CourseListView courseLV = new CourseListView();
        String[] options = {
            "Add online course/ offline course",
            "Update course",
            "Delete course",
            "Print all / online course / offline course",
            "Search information base on course ID"
        };
        Menu menu = new Menu("*** Course Management ***", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        courseLV.addCourse();
                        break;
                    }
                    case 2 -> {
                        courseLV.updateCourse();
                        break;
                    }
                    case 3 -> {
                        courseLV.deleteCourse();
                        break;
                    }
                    case 4 -> {
                        courseLV.display();
                        break;
                    }
                    case 5 -> {
                        courseLV.searchCourse();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
