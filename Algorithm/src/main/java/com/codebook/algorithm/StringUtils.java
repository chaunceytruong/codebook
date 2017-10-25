package com.codebook.algorithm;


import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class StringUtils {

    public static String removeDuplicates(@NotNull final String s) {
        if (s == null) {
            throw new IllegalArgumentException("Must specify a non-null argument.");
        }

        int len = s.length();
        if (len < 2) {
            return s;
        }

        Map<Character, Boolean> hits = new HashMap<Character, Boolean>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!hits.containsKey(ch)) {
                sb.append(ch);
            }
            hits.put(s.charAt(i), true);
        }

        return sb.toString();
    }

    /**
     * Stacks: Balanced Brackets
     *
     * https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
     *
     * @param expression expression string
     * @return true if balanced, false otherwise
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.empty()) {
                    return false;
                }

                if (!isPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isPair(char opening, char closing) {
        switch (opening) {
            case '{':
                return closing == '}';
            case '[':
                return closing == ']';
            case '(':
                return closing == ')';
            default:
                return false;
        }
    }

    public static boolean ransomNote(String magazineContent, String ransomContent) {
        String magazine[] = magazineContent.split(" ");
        String ransom[] = ransomContent.split(" ");
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        for (String magazineWord : magazine) {
            if (!wordCounts.containsKey(magazineWord)) {
                wordCounts.put(magazineWord, 1);
            } else {
                int count = wordCounts.get(magazineWord) + 1;
                wordCounts.put(magazineWord, count);
            }
        }
        for (String ransomWord : ransom) {
            if (!wordCounts.containsKey(ransomWord) || wordCounts.get(ransomWord) == 0) {
                return false;
            } else {
                int count = wordCounts.get(ransomWord) - 1;
                wordCounts.put(ransomWord, count);
            }
        }
        return true;
    }
}
