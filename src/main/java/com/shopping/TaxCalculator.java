package com.shopping;

public class TaxCalculator {
    public static double calculateTax(String state, double subtotal) {
        if (state.equalsIgnoreCase("IL") ||
            state.equalsIgnoreCase("CA") ||
            state.equalsIgnoreCase("NY")) {
            return subtotal * 0.06;
        }
        return 0.0;
    }
}