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

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abababab"));
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
