package com.ilya.coding;

public class LongestPalindrome {

    // returns longest palindromic substring given a string s
    public static String longestPalindrome(String s) {
        // error checking
        if (s == null) {
            return null;
        } else if (s.isEmpty()) {
            return s;
        }

        // init vars
        int maxLength = 0;
        String longestPalSub = "";

        // try to find longtest palindromic substring
        // starting at each point
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                boolean isPalindome = true;
                int a = i;
                int b = j;
                while (a < b) {
                    if (s.charAt(a) != s.charAt(b)) {
                        isPalindome = false;
                        break;
                    }
                    a++;
                    b--;
                }
                // longest so far?
                if (isPalindome && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    // substring from i to j inclusive from both sides
                    longestPalSub = s.substring(i, j + 1);
                }
            }
        }

        return longestPalSub;
    }

    // DP solution
    private static Boolean[][] dp;
    private static int maxLengthDP;
    private static String longestPalSubDP;

    // returns longest palindromic substring given a string s
    public static String longestPalindromeDP(String s) {
        // error checking
        if (s == null) {
            return null;
        } else if (s.isEmpty()) {
            return s;
        }

        // init vars
        int n = s.length();
        dp = new Boolean[n][n];
        maxLengthDP = 0;
        longestPalSubDP = "";

        isPalindromeDP(0, n - 1, n, s);

        return longestPalSubDP;
    }

    private static boolean isPalindromeDP(int i, int j, int n, String s) {
        // error checking
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return false;
        }

        // computed already?
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // single char palindrome?
        if (i == j) {
            dp[i][j] = true;
            checkLongest(i, j, s);
            return true;
        } else if (j == i + 1) {
            if (s.charAt(i) == s.charAt(j)) {
                // two char palindrome?
                dp[i][j] = true;
                checkLongest(i, j, s);
                return true;
            } else {
                dp[i][j] = false;
                return false;
            }
        }

        // populate other cells
        isPalindromeDP(i, j - 1, n, s);
        isPalindromeDP(i + 1, j, n, s);

        if (isPalindromeDP(i + 1, j  - 1, n, s)) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = true;
                checkLongest(i, j, s);
                return true;
            }
        }

        dp[i][j] = false;
        return false;
    }

    private static void checkLongest(int i, int j, String s) {
        if (dp[i][j] == true && (j - i + 1) > maxLengthDP) {
            maxLengthDP = j - i + 1;
            // substring from i to j inclusive from both sides
            longestPalSubDP = s.substring(i, j + 1);
        }
    }
}
