/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week4.studentmanagement.model;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Student implements Comparable<Student>{
    private String id;
    private String studentName;
    private int semester;
    private String courseName;

    public Student() {
    }
    

    public Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.studentName);
        hash = 23 * hash + this.semester;
        hash = 23 * hash + Objects.hashCode(this.courseName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.semester != other.semester) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.studentName, other.studentName)) {
            return false;
        }
        return Objects.equals(this.courseName, other.courseName);
    }
    
    @Override
    public String toString() {
        return String.format("%-20s | %-10d | %-10s", studentName, semester, courseName);
    }
    
    @Override
    public int compareTo(Student other) {
        return this.studentName.compareTo(other.studentName);
    }
    
    
}
