package com.ilya.coding;

public class LongestIncreasingSubsequenceDP {

    private static int overallMaxLength = -1;
    public static int countCalls = 0;

    /**
     * LIS(i) = 1 + max(LIS(j)) where 0 < j < i and a[i] > a[j]
     * LIS(i) = 1, if no such j exists
     * @param a
     * @return LIS
     */
    public static int longestIncreasingSubsequence(int[] a) {
        // error checking
        if (a == null || a.length == 0) {
            return -1;
        }

        overallMaxLength = -1;
        countCalls = 0;
        longestIncreasingSubsequenceRec(a, a.length - 1);
        return overallMaxLength;
    }

    private static int longestIncreasingSubsequenceRec(int[] a, int i) {
        countCalls++;
        if (i <= 0) {
            return 1;
        }

        int maxLength = -1;

        for (int j = i - 1; j >= 0; j--) {
            int longestAtJ = longestIncreasingSubsequenceRec(a, j);
            if (a[i] > a[j] && maxLength < longestAtJ + 1) {
                maxLength = longestAtJ + 1;
            }
        }

        if (overallMaxLength < maxLength) {
            overallMaxLength = maxLength;
        }

        return maxLength;
    }

    public static int longestIncreasingSubsequenceDP(int[] a) {
        // error checking
        if (a == null || a.length == 0) {
            return -1;
        }

        int n = a.length;
        int[] lis = new int[n];
        // init lis DP array to 1
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        int maxLength = -1;

        // bottom up populate longest subsequnce
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    if (maxLength < lis[i]) {
                        maxLength = lis[i];
                    }
                }
            }
        }

        return maxLength;
    }

}
