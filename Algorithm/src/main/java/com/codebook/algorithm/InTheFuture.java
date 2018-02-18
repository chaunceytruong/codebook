package com.codebook.algorithm;

public class InTheFuture {

    /**
     * Asha solves A problems per day.
     * Kelly solves K problems per day.
     * Asha is already P problems ahead of Kelly.
     *
     * @param A Asha's problem solving rate.
     * @param K Kelly's problem solving rate.
     * @param P Asha's lead over Kelly.
     *
     * @return Number of days for Kelly to overtake Asha.
     */
    public int inTheFuture(int A, int K, int P) {
        if (P <= 0 && K > A) {
            return 1;
        }

        int netDifference = K - A;
        if (netDifference < 1) {
            return -1;
        }

        return (int) Math.ceil((double) P / (double) netDifference);
    }
}
