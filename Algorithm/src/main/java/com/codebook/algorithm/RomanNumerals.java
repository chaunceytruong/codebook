package com.codebook.algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    static Map<Character, Integer> romanNumeralsToDecimal = new HashMap<Character, Integer>();

    static {
        romanNumeralsToDecimal.put('I', 1);
        romanNumeralsToDecimal.put('V', 5);
        romanNumeralsToDecimal.put('X', 10);
        romanNumeralsToDecimal.put('L', 50);
        romanNumeralsToDecimal.put('C', 100);
        romanNumeralsToDecimal.put('D', 500);
        romanNumeralsToDecimal.put('M', 1000);
    }

    int convertToDecimal(String romanNumerals) {
        int result = 0;
        int prev = 0;
        for (int i = romanNumerals.length() - 1; i >= 0; i--) {
            int current = romanNumeralsToDecimal.get(romanNumerals.toUpperCase().charAt(i));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanNumerals().convertToDecimal("MCMLXIX"));
    }

}
