/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.view;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Validation;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model.Candidate;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model.CandidateList;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model.ExperienceCandidate;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model.FresherCandidate;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model.InternCandidate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class CandidateListView {

    private CandidateList candidateList = new CandidateList();

    public void createCandidate(int n) {
        do {
            int id = candidateList.getCandidates().size() + 1;
            System.out.print("Enter first name: ");
            String firstName = Validation.inputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.inputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.inputIntegerInRange(1900, LocalDate.now().getYear());
            System.out.print("Enter address: ");
            String address = Validation.inputString();
            System.out.print("Enter phone: ");
            String phone = Validation.inputDigitStringWithLength(10);
            System.out.print("Enter email: ");
            String email = Validation.inputEmailFormat();
            switch (n) {
                case 1 -> {
                    int candidateType = 0;
                    System.out.print("Enter year of experience: ");
                    int expInYear = Validation.inputIntegerInRange(0, 100);
                    System.out.print("Enter professional skill: ");
                    String proSkill = Validation.inputString();
                    Candidate candidate = new ExperienceCandidate(expInYear, proSkill, id, candidateType, firstName, lastName, address, phone, email, birthDate);
                    candidateList.addCandidate(candidate);
                    break;
                }
                case 2 -> {
                    int candidateType = 1;
                    System.out.print("Enter graduation date: ");
                    Date graduationDate = Validation.inputDate();
                    System.out.print("Enter graduation rank: ");
                    String graduationRank = Validation.inputStringInFormat(new String[]{"Excellent", "Good", "Fair", "Poor"});
                    System.out.print("Enter university: ");
                    String education = Validation.inputString();
                    Candidate candidate = new FresherCandidate(graduationDate, graduationRank, education, id, candidateType, firstName, lastName, address, phone, email, birthDate);
                    candidateList.addCandidate(candidate);
                    break;
                }
                case 3 -> {
                    int candidateType = 2;
                    System.out.print("Enter major: ");
                    String major = Validation.inputString();
                    System.out.print("Enter semester: ");
                    int semester = Validation.inputPositiveInteger();
                    System.out.print("Enter university: ");
                    String universityName = Validation.inputString();
                    Candidate candidate = new InternCandidate(major, universityName, semester, id, candidateType, firstName, lastName, address, phone, email, birthDate);
                    candidateList.addCandidate(candidate);
                    break;
                }
            }
        } while (isContinued());
        displayAll();
    }
    
    private boolean isContinued() {
        System.out.println("Do you want to continue (Y/N)?");
        String choice = Validation.inputStringInFormat(new String[]{"Y", "N"});
        return choice.equalsIgnoreCase("Y");
    }
    
    private void displayAll() {
        if (candidateList.getCandidates().isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        boolean isNull = true;
        System.out.println("==========EXPERIENCE CANDIDATE==========");
        System.out.println("CandidateID | Full Name | Birth Date | Address | Phone | Email | Year of Experience | Professional Skill");
        for (Candidate c : candidateList.getCandidates()) {
            if (c instanceof ExperienceCandidate) {
                System.out.println(c);
                isNull = false;
            }
        }
        if (isNull) System.out.println("NULL");
        System.out.println("==========FRESHER CANDIDATE==========");
        System.out.println("CandidateID | Full Name | Birth Date | Address | Phone | Email | Graduation Date | Graduation Rank | Education");
        isNull = true;
        for (Candidate c : candidateList.getCandidates()) {
            if (c instanceof FresherCandidate) {
                System.out.println(c);
                isNull = false;
            }
        }
        if (isNull) System.out.println("NULL");
        System.out.println("==========FRESHER CANDIDATE==========");
        System.out.println("CandidateID | Full Name | Birth Date | Address | Phone | Email | Majors | Semester | University Name");
        isNull = true;
        for (Candidate c : candidateList.getCandidates()) {
            if (c instanceof InternCandidate) {
                System.out.println(c);
                isNull = false;
            }
        }
        if (isNull) System.out.println("NULL");
    }
    private void displayName() {
        if (candidateList.getCandidates().isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        boolean isNull = true;
        System.out.println("==========EXPERIENCE CANDIDATE==========");
        for (Candidate c : candidateList.getCandidates()) {
            if (c instanceof ExperienceCandidate) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
                isNull = false;
            }
        }
        if (isNull) System.out.println("NULL");
        System.out.println("==========FRESHER CANDIDATE==========");
        isNull = true;
        for (Candidate c : candidateList.getCandidates()) {
            if (c instanceof FresherCandidate) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
                isNull = false;
            }
        }
        if (isNull) System.out.println("NULL");
        System.out.println("==========FRESHER CANDIDATE==========");
        isNull = true;
        for (Candidate c : candidateList.getCandidates()) {
            if (c instanceof InternCandidate) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
                isNull = false;
            }
        }
        if (isNull) System.out.println("NULL");
    }
    public void search() {
        displayName();
        System.out.println("Input Candidate name (First name or Last name): ");
        String name = Validation.inputString();
        System.out.println("Input type of candidate: ");
        int type = Validation.inputIntegerInRange(0, 2);
        ArrayList<Candidate> results = candidateList.search(name, type);
        if (results.isEmpty()) {
            System.out.println("Candidate not found");
        } else {
            System.out.println("The candidates found:");
            for (Candidate c : results) {
                System.out.println(c.getFirstName() + " " + c.getLastName()
                                + " | " + c.getBirthDate() + " | " + c.getAddress()
                                + " | " + c.getPhone() + " | " + c.getEmail() + " | " + c.getCandidateType());
            }
        }
    }
}
