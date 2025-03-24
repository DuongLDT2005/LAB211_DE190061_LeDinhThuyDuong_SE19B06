/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week9.model;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CandidateList {
    private ArrayList<Candidate> candidates = new ArrayList<>();

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }
    public ArrayList<Candidate> search(String name, int type) {
        ArrayList<Candidate> results = new ArrayList<>();
        for (Candidate c : candidates) {
            if ((c.getFirstName().contains(name) || c.getLastName().contains(name)) && c.getCandidateType() == type) {
                results.add(c);
            }
        }
        return results;
    }
}
