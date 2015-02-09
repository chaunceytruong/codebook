package com.codebook.algorithm;


import com.sun.javafx.beans.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;


public class StringUtils {

    public static String removeDuplicates(@NonNull final String s) {
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
        System.out.println(removeDuplicates("abababab"));
    }
}
