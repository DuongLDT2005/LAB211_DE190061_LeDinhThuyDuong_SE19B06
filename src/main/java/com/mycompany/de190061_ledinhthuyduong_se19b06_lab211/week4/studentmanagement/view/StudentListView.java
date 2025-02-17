/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.model.Student;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.model.StudentList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class StudentListView {

    private StudentList studentList = new StudentList();

    public void create() {
        while (studentList.getStudents().size() < 3 || isContinue()) {
            System.out.println("Enter ID:");
            String id = Validation.inputString();
            System.out.println("Enter student name:");
            String studentName = Validation.inputString();
            System.out.println("Enter semester:");
            int semester = Validation.inputPositiveInteger();
            System.out.println("Enter course name (Java, .Net, C/C++):");
            String courseName = Validation.inputStringInFormat(new String[]{"Java", ".Net", "C/C++"});
            Student student = new Student(id, studentName, semester, courseName);
            if (studentList.checkStudent(student)) {
                studentList.addStudent(student);
                System.out.println("Create successfully!");
            } else {
                System.out.println("Student has duplicated courses in a semester! Please enter again!");
            }
        }
    }

    public boolean isContinue() {
        System.out.println("Do you want to continue (Y/N)?");
        return Validation.inputStringInFormat(new String[]{"Y", "N"}).equalsIgnoreCase("Y");
    }

    public void findAndSort() {
        System.out.println("Enter student name to search:");
        String nameToSearch = Validation.inputString();
        ArrayList<Student> results = studentList.findStudent(student -> student.getStudentName().contains(nameToSearch), studentList.getStudents());
        if (!results.isEmpty()) {
            studentList.sortStudent(results);
            System.out.printf("%-20s | %-10s | %-10s", "Student Name", "Semester", "Course Name");
            for (Student s : results) {
                System.out.println(s);
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public void updateOrDelete() {
        System.out.println("Enter ID to update/delete:");
        String id = Validation.inputString();
        ArrayList<Student> result = studentList.findStudent(student -> student.getId().equals(id), studentList.getStudents());
        if (result.isEmpty()) {
            System.out.println("Student not found!");
            return;
        }
        System.out.println("Do you want to update(U) or delete(D) student?");
        String action = Validation.inputStringInFormat(new String[]{"U", "D"});
        
        if (action.equalsIgnoreCase("U")) {
            if (result.size() == 1) {
                updateStudent(result.get(0));
                return;
            }
            
            System.out.println("Enter semester to find: ");
            int semester = Validation.inputPositiveInteger();
            ArrayList<Student> semesterList = studentList.findStudent(student -> student.getSemester() == semester, result);
            if (semesterList.isEmpty()) {
                System.out.println("Student not found!");
                return;
            }
            if (semesterList.size() == 1) {
                updateStudent(semesterList.get(0));
                return;
            }
            
            System.out.println("Enter course name to find: ");
            String courseName = Validation.inputStringInFormat(new String[]{"Java", ".Net", "C/C++"});
            ArrayList<Student> courseList = studentList.findStudent(student -> student.getCourseName().equals(courseName), semesterList);
            if (!courseList.isEmpty()) {
                updateStudent(courseList.get(0));
            } else {
                System.out.println("Student not found!");
            }
        } else {
            studentList.deleteStudent(result);
            System.out.println("Delete successfully!");
        }
    }

    public void updateStudent(Student s) {
        String[] options = {
            "Update semester",
            "Update course name"
        };
        Menu updateMenu = new Menu("Update Menu", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 2 -> {
                        System.out.println("Enter semester:");
                        int semester = Validation.inputPositiveInteger();
                        s.setSemester(semester);
                        System.out.println("Update successfully!");
                        break;
                    }
                    case 3 -> {
                        System.out.println("Enter course name:");
                        String courseName = Validation.inputStringInFormat(new String[]{"Java", ".Net", "C/C++"});
                        s.setCourseName(courseName);
                        System.out.println("Update successfully!");
                        break;
                    }
                }
            }
        };
        updateMenu.run();
    }

    public void report() {
        Map<String, Integer> studentReport = new HashMap<>();
        for (Student s : studentList.getStudents()) {
            String key = s.getId() + " | " + s.getStudentName() + " | " + s.getCourseName();
            studentReport.put(key, studentReport.getOrDefault(key, 0) + 1);
        }
        for (var entry : studentReport.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}
