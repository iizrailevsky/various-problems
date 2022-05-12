package com.ilya.coding;

/**
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 * Return the maximum amount of split balanced strings.
 * Input: s String
 * Output: Number of balanced substrings
 * Constraints: 1 <= s.length <= 1000
 * Example 1:
 *      s = "RLRRLLRLRL", output: 4, s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'
 * Example 2:
 *      s = "RLLLLRRRLR", output: 3, s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'
 * Example 3:
 *      s = "LLLLRRRR", output: 1, s can be split into "LLLLRRRR"
 * Options: Increment running balance if 'L' and decrement if 'R'.
 *          If balance reached 0, increment total count by 1.
 *          Time: O(N), Space: O(N) where N - length of the string
 */
public class BalancedString {
    public static int balancedStringSplit(String s) {
        // error checking
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // init vars
        int balanceCnt = 0;
        int count = 0;

        // go over the chars and count number of balanced substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balanceCnt++;
            } else {
                // found 'R'
                balanceCnt--;
            }

            // balanceCnt reached 0? increment total count
            if (balanceCnt == 0) {
                count++;
            }
        }

        return count;
    }
}
