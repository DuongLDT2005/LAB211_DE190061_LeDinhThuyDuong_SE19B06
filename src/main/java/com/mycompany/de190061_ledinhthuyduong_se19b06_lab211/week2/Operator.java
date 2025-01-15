/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week2;

/**
 *
 * @author DELL
 */
public enum Operator {    
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    POWER("^");
    
    private final String symbol;
    
    public String getSymbol() {
        return symbol;
    }

    private Operator(String symbol) {
        this.symbol = symbol;
    }
    
    static public Operator getOp(String op) {
        for (Operator opt : Operator.values()) {
            if (opt.getSymbol().equals(op)) {
                return opt;
            }
        }
        return null;
    }
    
}
