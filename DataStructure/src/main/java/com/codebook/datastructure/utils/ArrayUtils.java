package com.codebook.datastructure.utils;


import com.sun.javafx.beans.annotations.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ArrayUtils {
    /**
     * Merges two sorted arrays (using an auxiliary array).
     *
     * @param a First sorted array
     * @param b Second sorted array
     *
     * @return Sorted array containing values from both a and b.
     */
    public static int[] mergeSorted(int[] a, int[] b) {
        int size = a.length + b.length;
        int[] c = new int[size];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] <= b[indexB]) {
                c[indexC++] = a[indexA++];
            } else {
                c[indexC++] = b[indexB++];
            }
        }
        while (indexA <= a.length) {    // Copy rest of a
            c[indexC++] = a[indexA++];
        }
        while (indexB <= b.length) {    // Copy rest of b
            c[indexC++] = b[indexB++];
        }
        return c;
    }

    /**
     * Merge array size N into array size 2N (both are sorted).
     *
     * a:   [1,5,9]
     * b:   [1,2,6, , , ]
     * c:   [1,1,2,5,6,9]
     *
     * @param a First sorted array
     * @param b Second sorted array
     */
    public static void mergeSortedInto(int[] a, int[] b) {
        int indexA = a.length - 1;
        int indexB = indexA;
        int indexCurrent = b.length - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] > b[indexB]) {
                b[indexCurrent--] = a[indexA--];
            } else {
                b[indexCurrent--] = b[indexB--];
            }
        }

        while (indexA >= 0) {
            b[indexCurrent--] = a[indexA--];
        }
    }

    /**
     * 3-ELEMENT SUBSET THAT SUMS TO ZERO --- O(N) + O(N^2)
     *
     * @param values    Array of integers
     * @param sum       Target subset sum
     *
     * return true if 3-element subset that sums to the target sum exists, false otherwise
     */
    public static boolean threeElementSubsetWithSum(int[] values, int sum) {
        Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
        for (int value : values) {
            int count = elements.get(value) == null ? 0 : elements.get(value);
            elements.put(value, count + 1);
        }
        for (int i : values) {
            for (int j : values) {
                int current = i + j;
                int remainder = sum - current;
                Integer remainderCount = elements.get(remainder);
                if (remainderCount != null) {
                    if (i == remainder) {
                        remainderCount--;
                    }
                    if (j == remainder) {
                        remainderCount--;
                    }
                    if (remainderCount > 0) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static int longestConsecutiveSequence(@NonNull int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int currentLength = 1;
        int maxLength = currentLength;

        for (int i = 0; i < values.length - 1; i++) {
            int previous = values[i];
            int current = values[i + 1];
            if (current > previous) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            maxLength = Math.max(currentLength, maxLength);
            System.out.println(String.format(
                    "current: %s previous: %s currentLength: %s maxLength: %s",
                    current, previous, currentLength, maxLength));
        }

        return maxLength;
    }

    public static int longestConsecutiveSequence(@NonNull Iterator<Integer> values) {
        if (!values.hasNext()) {
            return 0;
        }

        int currentLength = 1;
        int maxLength = currentLength;

        while (values.hasNext()) {
            int previous = values.next();
            int current = values.next();
            if (current > previous) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            maxLength = Math.max(currentLength, maxLength);
            System.out.println(String.format(
                    "current: %s previous: %s currentLength: %s maxLength: %s",
                    current, previous, currentLength, maxLength));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("LCS: " + longestConsecutiveSequence(new int[]{ 1, 7, 6, 9, 10, 4 }));
        System.out.println("LCS: " + longestConsecutiveSequence(Arrays.asList(1, 7, 6, 9, 10, 4).iterator()));

    }
}
