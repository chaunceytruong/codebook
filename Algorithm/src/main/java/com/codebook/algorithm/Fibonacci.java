package com.codebook.algorithm;

public class Fibonacci {

    public int recursive(int n) {
        if (n < 0) {
            return 0;
        } else if (n < 2) {
            return n;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    public int dynamic(int n) {
        if (n < 0) {
            return 0;
        }

        int[] fibValues = new int[n + 2];
        fibValues[0] = 0;
        fibValues[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibValues[i] = fibValues[i - 1] + fibValues[i -2];
        }

        return fibValues[n];
    }
}
