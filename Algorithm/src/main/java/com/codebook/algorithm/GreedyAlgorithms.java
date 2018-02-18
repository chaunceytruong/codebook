package com.codebook.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyAlgorithms {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        List<Integer> values = new ArrayList<Integer>();
        for (int value : arr) {
            values.add(value);
        }
        Collections.sort(values);
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int diff = values.get(i + 1) - values.get(i);
            if (diff < minAbsDiff) {
                minAbsDiff = diff;
            }
        }
        return minAbsDiff;
    }

}
