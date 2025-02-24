/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.model.Course;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.model.CourseList;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.model.OfflineCourse;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week5.coursemanagement.model.OnlineCourse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class CourseListView {

    private CourseList courseList = new CourseList();

    private boolean chooseTypeCourse(String choice) {
        return choice.equalsIgnoreCase("O");
    }

    public void addCourse() {
        System.out.println("*** Add new course ***");
        System.out.print("Online (O) or Offline (F): ");
        String choice = Validation.inputStringInFormat(new String[]{"O", "F"});
        boolean isOnline = chooseTypeCourse(choice);
        if (isOnline) {
            System.out.println("Create new online course");
        } else {
            System.out.println("Create new offline course");
        }
        String courseID;
        boolean isDuplicated;
        do {
            System.out.print("Course ID: ");
            courseID = Validation.inputString();
            isDuplicated = false;
            for (Course c : courseList.getCourses()) {
                if (c.getCourseID().equalsIgnoreCase(courseID)) {
                    System.out.println("Data input is invalid, ID must be unique");
                    isDuplicated = true;
                }
            }
        } while (isDuplicated);
        String courseName;
        do {
            System.out.print("Course name: ");
            courseName = Validation.inputString();
            isDuplicated = false;
            for (Course c : courseList.getCourses()) {
                if (c.getCourseName().equalsIgnoreCase(courseName)) {
                    System.out.println("Data input is invalid, course name must be unique");
                    isDuplicated = true;

                }
            }
        } while (isDuplicated);
        System.out.print("Credits: ");
        int credits = Validation.inputPositiveInteger();
        if (isOnline) {
            System.out.print("Platform: ");
            String platform = Validation.inputString();
            System.out.print("Instructor: ");
            String instructor = Validation.inputString();
            System.out.print("Note: ");
            String note = Validation.inputString();
            Course onlineCourse = new OnlineCourse(courseID, courseName, credits, platform, instructor, note);
            courseList.addCourse(onlineCourse);
        } else {
            Date begin, end;
            boolean isValidTime;
            do {
                System.out.print("Begin: ");
                begin = Validation.inputDateFormatInFuture();
                System.out.print("End: ");
                end = Validation.inputDateFormatInFuture();
                isValidTime = Validation.checkBeginEndDate(begin, end);
                if (!isValidTime) {
                    System.out.println("Data input is invalid! End must be after begin!");
                }
            } while (!isValidTime);
            System.out.print("Campus: ");
            String campus = Validation.inputString();
            Course offlineCourse = new OfflineCourse(courseID, courseName, credits, begin, end, campus);
            courseList.addCourse(offlineCourse);
        }
    }

    private void displayOneCourse(Course course) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Course ID: " + course.getCourseID());
        System.out.println("Course name: " + course.getCourseName());
        System.out.println("Credits: " + course.getCredits());
        if (course instanceof OnlineCourse) {
            System.out.println("Platform: " + ((OnlineCourse) course).getPlatform());
            System.out.println("Instructors: " + ((OnlineCourse) course).getInstructor());
            System.out.println("Note: " + ((OnlineCourse) course).getNote());
        } else {
            System.out.println("Begin: " + sdf.format(((OfflineCourse)course).getBegin()));
            System.out.println("End: " + sdf.format(((OfflineCourse)course).getEnd()));
            System.out.println("Campus: " + ((OfflineCourse) course).getCampus());
        }
    }

    private boolean isContinueToFind() {
        System.out.print("No data found, do you want to find again? (Y/N): ");
        return Validation.inputStringInFormat(new String[]{"Y", "N"}).equalsIgnoreCase("Y");
    }

    private Course findCourseByID() {
        while (true) {
            System.out.print("Course ID: ");
            String id = Validation.inputString();
            Course result = courseList.searchCourse(course -> course.getCourseID().equalsIgnoreCase(id));
            if (result != null || !isContinueToFind()) {
                return result;
            }
        }
    }
    
    public void updateCourse() {
        System.out.println("*** Update course ***");
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Course updateCourse = findCourseByID();
        if (updateCourse == null) {
            return;
        }
        System.out.println("*** Search results ***");
        displayOneCourse(updateCourse);
        System.out.println("*** Updating ***");
        System.out.print("Course ID: ");
        String id = sc.nextLine();
        if (!id.isBlank()) {
            updateCourse.setCourseID(id);
        }
        System.out.print("Course name: ");
        String name = sc.nextLine();
        if (!name.isBlank()) {
            updateCourse.setCourseName(name);
        }
        System.out.print("Credits: ");
        String creditStr = sc.nextLine();
        if (!creditStr.isBlank()) {
            int credit = Integer.parseInt(creditStr);
            if (credit > 0) updateCourse.setCredits(credit);
        }
        if (updateCourse instanceof OnlineCourse) {
            System.out.print("Platform: ");
            String platform = sc.nextLine();
            if (!platform.isBlank()) {
                ((OnlineCourse) updateCourse).setPlatform(platform);
            }
            System.out.print("Instructors: ");
            String instructors = sc.nextLine();
            if (!instructors.isBlank()) {
                ((OnlineCourse) updateCourse).setInstructor(instructors);
            }
            System.out.print("Note: ");
            String note = sc.nextLine();
            if (!note.isBlank()) {
                ((OnlineCourse) updateCourse).setNote(note);
            }
        } else {
            System.out.print("Begin: ");
            String beginStr = sc.nextLine();
            if (!beginStr.isBlank()) {
                try {
                    Date begin = sdf.parse(beginStr);
                    if (begin.after(new Date())) ((OfflineCourse) updateCourse).setBegin(begin);
                } catch (ParseException ex) {
                    System.out.println("Data input is invalid! Skip to set input!");
                }
            }
            System.out.print("End: ");
            String endStr = sc.nextLine();
            if (!endStr.isBlank()) {
                try {
                    Date end = sdf.parse(endStr);
                    if (end.after(new Date()) && end.before(((OfflineCourse) updateCourse).getBegin())) ((OfflineCourse) updateCourse).setEnd(end);
                } catch (ParseException ex) {
                    System.out.println("Data input is invalid! Skip to set input!");
                }
            }
            System.out.print("Campus: ");
            String campus = sc.nextLine();
            if (!campus.isBlank()) {
                ((OfflineCourse) updateCourse).setCampus(campus);
            }
        }
        System.out.println("Updated successfully!");
    }

    public void deleteCourse() {
        System.out.println("*** Delete course ***");
        Course deleteCourse = findCourseByID();
        if (deleteCourse != null) {
            courseList.deleteCourse(deleteCourse);
            System.out.println("Delete successfully!");
        }
    }

    public void display() {
        System.out.println("*** Print course ***");
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String choice = Validation.inputStringInFormat(new String[]{"A", "O", "F"}).toUpperCase();
        if (courseList.getCourses().isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        switch (choice) {
            case "O" -> {
                System.out.println("Course ID | Course Name | Credits | Platform | Instructors | Note");
                for (Course course : courseList.getCourses()) {
                    if (course instanceof OnlineCourse) {
                        System.out.println(course);
                    }
                }
                break;
            }
            case "F" -> {
                System.out.println("Course ID | Course Name | Credits | Begin | End | Campus");
                for (Course course : courseList.getCourses()) {
                    if (course instanceof OfflineCourse) {
                        System.out.println(course);
                    }
                }
                break;
            }
            case "A" -> {
                System.out.println("Course ID | Course Name | Credits");
                for (Course course : courseList.getCourses()) {
                    System.out.println(course.getCourseID() + " | " + course.getCourseName() + " | " + course.getCredits());
                }
                break;
            }
        }
    }

    public void searchCourse() {
        System.out.println("*** Searching ***");
        Course result = findCourseByID();
        if (result != null) {
            System.out.println("*** Search results ***");
            displayOneCourse(result);
        }
    }
}
