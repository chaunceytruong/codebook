package com.codebook.algorithm;

import com.sun.istack.internal.NotNull;

public class LongestPalindromicSubsequence {

    /**
     * Returns the length of the longest palindromic subsequence in seq
     *
     * @param s
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int lpsRecursive(@NotNull String s, int startIndex, int endIndex) {

        // Base Case 1: If there is only 1 character
        if (startIndex == endIndex) {
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are the same
        if (s.charAt(startIndex) == s.charAt(endIndex) && startIndex + 1 == endIndex) {
            return 2;
        }

        // If the first and last characters match
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return lpsRecursive(s, startIndex + 1, endIndex - 1) + 2;
        }

        // If the first and last characters do not match
        return Math.max(lpsRecursive(s, startIndex, endIndex - 1), lpsRecursive(s, startIndex + 1, endIndex));
    }

    /**
     * Returns the length of the longest palindromic subsequence in seq
     *
     * @param seq
     */
    public static int lpsDynamic(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // https://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl=2; cl<=n; cl++) {
            for (i=0; i<n-cl+1; i++) {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
            }
        }

        return L[0][n-1];
    }

    public static void main(String[] args) {
        String seq = "vdvdvdvdvdvdvvdvvdvvvdd";
        System.out.println(lpsRecursive(seq, 0, seq.length() - 1));
    }
}
