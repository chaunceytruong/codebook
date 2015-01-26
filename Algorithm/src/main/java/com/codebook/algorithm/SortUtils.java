package com.codebook.algorithm;


import java.util.Arrays;

/**
 * Class SortUtils contains a collection of sorting utilities.
 */
public class SortUtils {

    /**
     * Merge sort an array of integers (in-place).
     *
     * @param values Array of integers (unsorted)
     */
    public static void mergeSort(int[] values) {
        System.out.println("Unsorted: \t" + Arrays.toString(values));
        mergeSort(
                values,
                new int[values.length],
                0,
                values.length-1);
        System.out.println("Sorted: \t" + Arrays.toString(values));
    }

    /**
     * Internal method that makes recursive calls.
     * @param a an array of int.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the sub-array.
     * @param right the right-most index of the sub-array.
     */
    private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two Sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd ) {
        int leftEnd = rightPos - 1;
        int curPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                tmpArray[curPos++] = a[leftPos++];
            } else {
                tmpArray[curPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {	// Copy rest of first half
            tmpArray[curPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {	// Copy rest of right half
            tmpArray[curPos++] = a[rightPos++];
        }

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}
