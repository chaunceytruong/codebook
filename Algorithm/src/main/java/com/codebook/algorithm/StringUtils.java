package com.codebook.algorithm;


import com.sun.istack.internal.NotNull;

import java.util.*;


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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(balancedOrNot(new String[] { "<>", "<>><" }, new int[] { 2, 1})));
    }

    /*
     * Complete the function below.
     */
    public static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int length = expressions.length;
        int[] expressionsBalanced = new int[expressions.length];
        for (int i = 0; i < length; i++) {
            String expression = expressions[i];
            int maxReplaceForExpression = maxReplacements[i];
            expressionsBalanced[i] = isStringBalancedWithReplacements(expression, maxReplaceForExpression);
        }
        return expressionsBalanced;
    }

    /**
     * Check if the specified string is balanced up to max replacements.
     *
     * @param expression string expression.
     * @param maxReplacement number of replacements allowed.
     * @return true if balanced, false otherwise.
     */
    private static int isStringBalancedWithReplacements(String expression, int maxReplacement) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '<') {
                stack.push(ch);
            } else if (ch == '>') {
                if (stack.empty()) {
                    if (maxReplacement <= 0) {
                        return 0;
                    } else {
                        maxReplacement -= 1;
                    }
                } else {
                    stack.pop();
                }
            }
        }
        boolean isBalanced = stack.empty() && maxReplacement >= 0;
        return isBalanced ? 1 : 0;
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
