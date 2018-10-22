package com.ilya.coding;

import java.util.*;

public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<String> dset = new HashSet();
        for (int i = 1; i <= 26; i++) {
            dset.add(Integer.toString(i));
        }
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i] = -1;
        }

        return numDecodings(s, dset, dp, 0);
    }

    private static int numDecodings(String s, Set<String> dset, int[] dp, int index) {
        if (dp[index] != -1) {
            return dp[index];
        }

        if (s.isEmpty()) {
            dp[index] = 1;
            return 1;
        }

        int count = 0;
        int n = Math.min(s.length(), 2);

        for (int i = 1; i <= n; i++) {
            String start = s.substring(0, i);
            if (dset.contains(start)) {
                count += numDecodings(s.substring(i), dset, dp, index + i);
            }
        }

        dp[index] = count;
        System.out.println(Arrays.toString(dp));
        return count;
    }
}
