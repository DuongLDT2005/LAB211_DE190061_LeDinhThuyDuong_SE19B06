/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class OfflineCourse extends Course{
    private Date begin, end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }

    public OfflineCourse(String courseID, String courseName, int credits, Date begin, Date end, String campus) {
        super(courseID, courseName, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + " | " + sdf.format(begin) + " | " + sdf.format(end) + " | " + campus;
    }  
    
}
