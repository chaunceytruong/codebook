package com.codebook.algorithm;

public class Fibonacci {


    public int recursive(int n) {
        // Handle negative numbers.
        if (n < 0) {
            return 0;
            // No need to calculate for given values 0 and 1, just return them.
        } else if (n < 2) {
            return n;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    public int dynamic(int n) {
        // Handle negative numbers
        if (n < 0) {
            return 0;
            // No need to calculate for given values 0 and 1, just return them.
        } else if (n < 2) {
            return n;
        }

        // Store calculated values in an array for quick lookup.
        int[] fibValues = new int[n + 2];
        fibValues[0] = 0;
        fibValues[1] = 1;

        for (int i = 2; i <= n; i++) {
            // Calculate the new value and store it in the array.
            fibValues[i] = fibValues[i - 1] + fibValues[i -2];
        }

        // Return the stored value.
        return fibValues[n];
    }

    public int dynamicSpaceOptimized(int n) {
        // Handle negative numbers
        if (n < 0) {
            return 0;
            // No need to calculate for given values 0 and 1, just return them.
        } else if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;

        int c;
        for (int i = 2; i <= n; i++) {
            // Only store the most recent 2 values (a & b). This will reduce the space needed vs. keeping an array with all the stored values. We only care about the recent 2.
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
