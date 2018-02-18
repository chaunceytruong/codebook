package com.codebook.algorithm;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {


    public static int firstDuplicate(int[] values) {
        Set<Integer> seenValues = new HashSet<Integer>();
        for (int value : values) {
            if (seenValues.contains(value)) {
                return value;
            } else {
                seenValues.add(value);
            }
        }
        return -1;
    }
}
