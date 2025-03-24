/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.controller;

import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.Menu;
import com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.view.CandidateListView;

/**
 *
 * @author DELL
 */
public class CandidateManagement {
    public static void main(String[] args) {
        CandidateListView candidateLV = new CandidateListView();
        String[] choices = {
            "Experience",
            "Fresher",
            "Internship",
            "Searching"
        };
        Menu menu = new Menu("CANDIDATE MANAGEMENT SYSTEM", choices) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        candidateLV.createCandidate(n);
                        break;
                    }
                    case 2 -> {
                        candidateLV.createCandidate(n);
                        break;
                    }
                    case 3 -> {
                        candidateLV.createCandidate(n);
                        break;
                    }
                    case 4 -> {
                        candidateLV.search();
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
