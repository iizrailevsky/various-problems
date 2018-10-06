package com.ilya.coding;

import java.util.*;

public class PerfectSquaresLeastNumber {

    /**
     * Given a positive integer n, find the least number of
     * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
     * @param n
     * @return
     */

    public static int numSquares(int n) {
        // error checking
        if (n <= 0) {
            return -1;
        }

        List<Integer> perfSqs = calcPerfectSquares(n);
        int minNumPerfSqs = numSquaresRec(n, perfSqs, perfSqs.size() - 1);

        return minNumPerfSqs;
    }

    private static List<Integer> calcPerfectSquares(int n) {
        List<Integer> perfSqs = new ArrayList();
        for (int i = 1; i * i <= n; i++) {
            perfSqs.add(i * i);
        }
        return perfSqs;
    }

    private static int numSquaresRec(int n, List<Integer> perfSqs, int index) {
        if (index < 0) {
            return Integer.MAX_VALUE;
        }

        int numWithCur = Integer.MAX_VALUE;
        int numWOCur = Integer.MAX_VALUE;

        // try with current perfect square
        int curPS = perfSqs.get(index);
        if (n % curPS == 0) {
            numWithCur = n / curPS;
        } else {
            int numRest = numSquaresRec(n % curPS, perfSqs, index - 1);
            if (numRest != Integer.MAX_VALUE) {
                numWithCur = (n / curPS) + numRest;
            }
        }

        // try without current perfect square
        numWOCur = numSquaresRec(n, perfSqs, index - 1);

        return Math.min(numWithCur, numWOCur);
    }
}
