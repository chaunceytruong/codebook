package com.codebook.algorithm;

import java.util.HashSet;

public class CountPairsWithDifference {

    public int countPairsWithDiffK(int values[], int k) {
        int count = 0;  // Initialize count

        HashSet<Integer> distinctValues = new HashSet<Integer>();

        int max = 0;
        for (Integer value : values) {
            distinctValues.add(value);
            if (value > max) {
                max = value;
            }
        }

        for (Integer value : values) {
            if (value - k >= 0 && distinctValues.contains(value - k)) {
                count++;
            }
            if (distinctValues.contains(value + k)) {
                count++;
            }
            distinctValues.remove(value);
        }
        return count;
    }

    /**
     * Assume the values are sorted.
     *
     * @param values
     * @param k
     * @return number of pairs with difference k.
     */
    public int countPairsWithDifference(int values[], int k) {
        int count = 0;
        int l = 0;
        int r = 0;
        while (r < values.length) {
            if (values[r] - values[l] == k) {
                count++;
                l++;
                r++;
            } else if (values[r] - values[l] > k) {
                l++;
            } else {
                r++;
            }
        }
        return count;
    }
}
