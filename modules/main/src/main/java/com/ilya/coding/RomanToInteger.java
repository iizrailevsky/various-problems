package com.ilya.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * Converts a given Roman numeral to an integer
 * Input: Given Roman numberal s
 * Output: Integer res
 * Constraints:
 *          - 1 <= s.length <= 15
 *          - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 *          - It is guaranteed that s is a valid roman numeral in the range [1, 3999]
 *
 * Examples: s = "III", output: 3
 *           s = "LVIII", output: 58. L = 50, V = 5, III = 3
 *           s = "MCMXVIV", output: 1994. M = 1000, CM = 900, XC = 90, IV = 4
 *
 * Options: Map the various Roman characters to their value numbers, including 2-character values.
 *          Go over 2 or 1 characters at a time, add their values to the resulting integer to output.
 *          Time: O(N), Space: O(C)
 */
public class RomanToInteger {
    private static Map<String, Integer> romanToInt = new HashMap<>();
    static  {
        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);
        romanToInt.put("IV", 4);
        romanToInt.put("IX", 9);
        romanToInt.put("XL", 40);
        romanToInt.put("XC", 90);
        romanToInt.put("CD", 400);
        romanToInt.put("CM", 900);
    }

    public static int romanToInt(String s) {
        // error checking
        if (s == null || s.isEmpty()) {
            return -1;
        }

        // init vars
        int res = 0;
        int i = 0;
        int j;

        // go over 2 or 1 characters and add to res
        while (i < s.length()) {
            // try 2 characters 1st, then 1 character
            j = i + 2;

            // reached end of string? try one character only
            if (j > s.length()) {
                j--;
            }

            for (int k = 0; k < 2 && j <= s.length(); k++, j--) {
                String chars = s.substring(i, j);
                if (romanToInt.containsKey(chars)) {
                    res += romanToInt.get(chars);
                    i = j;
                    break;
                }
            }
        }

        return res;
    }
}
