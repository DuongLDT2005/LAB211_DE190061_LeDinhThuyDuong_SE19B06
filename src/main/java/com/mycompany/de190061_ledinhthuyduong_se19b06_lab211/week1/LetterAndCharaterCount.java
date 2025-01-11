/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week1;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author DELL
 */
public class LetterAndCharaterCount {
    private String str;

    public LetterAndCharaterCount(String stringValue) {
        this.str = stringValue;
    }
    
    public HashMap<String, Integer> countWord() {
        HashMap<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();       
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
    
    public HashMap<Character, Integer> countCharater() {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        return charCount;
    }
    
}
