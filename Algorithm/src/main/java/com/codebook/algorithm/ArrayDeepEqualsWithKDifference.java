package com.codebook.algorithm;

import java.util.*;

public class ArrayDeepEqualsWithKDifference {

    /**
     *
     * @param a
     * @param b
     * @param k Must be non-negative
     * @return
     */
    static boolean equals(int[] a, int[] b, int k) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        if (k >= a.length) {
            return true;
        }
        Map<Integer, Integer> aCounts = new HashMap<Integer, Integer>();
        for (int as : a) {
            int count = aCounts.containsKey(as) ? aCounts.get(as) : 0;
            aCounts.put(as, count + 1);
        }
        for (int bs : b) {
            if (!aCounts.containsKey(bs)) {
                return false;
            }
            int count = aCounts.get(bs);
            if (count <= 0) {
                k--;
            }
            if (k < 0) {
                return false;
            }
            aCounts.put(bs, count - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 7, 8 };
        int[] b = { 1, 2, 2, 2, 3, 4, 5 };
        System.out.print(equals(a, b, 2));
    }
}
