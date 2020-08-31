package com.ilya.coding;

import java.util.*;

/**
 Problem: Identify repeated sequences with the DNA.
 Each sequence: 10-letter-long substring
 Input: String s
 Output: List<String> of all repeated sequences
 Constraints: Input DNA molecule should be at least 10 letters long
 Example: Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 Options:
 1. Bruce force: Generate all available 10-letter substrings, put in Set. If occurs more than once, add to result list.
 Space: O(N^2)
 Time: O(N^2)
 2. Optimized: Convert A, C, G, T into numbers, use sliding window technique to slide through numbers and
 'remove' 1st digit and add the new one. E.g. if A -> 1, C -> 2, then "AAAC" would be "1112", with 3-letter slider,
 111 -> 112 by: (111 % 100) * 10 + 2 = 11 * 10 + 2 = 112.

 */

public class RepeatedDnaSequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        // error checking
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        // init vars
        char[] chars = s.toCharArray();
        int n = chars.length;
        int k = 10;
        Set<Long> uniqueSeqs = new HashSet<>();
        Set<String> resList = new HashSet<>();

        // get initial 10-letter sequence as a number
        long seq = charsToNumber(chars, k, n);
        uniqueSeqs.add(seq);

        // use sliding window technique to slide and calculate sequences
        for (int i = 0, j = k; i < n - k + 1 && j < n; i++, j++) {
            seq = (seq % 1000000000L) * 10 + charToNum(chars[j]);
            // repeated sequence? add to result set
            if (uniqueSeqs.contains(seq)) {
                resList.add(numberToString(seq));
            } else {
                uniqueSeqs.add(seq);
            }
        }

        return new ArrayList<String>(resList);
    }

    /**
     * Returns number for given char array
     * @param chars
     * @param k
     * @param n
     * @return number representation of given char array
     */
    private static long charsToNumber(char[] chars, int k, int n) {
        long res = charToNum(chars[0]);
        for (int i = 1; i < k; i++) {
            res = res * 10 + (charToNum(chars[i]));
        }

        return res;
    }

    /**
     * Returns string DNA sequence for a given number representation
     * @param n
     * @return string DNA sequence
     */
    private static String numberToString(long n) {
        StringBuffer b = new StringBuffer();

        while (n > 0) {
            b.append(numToChar(n % 10L));
            n /= 10L;
        }

        return b.reverse().toString();
    }

    private static long charToNum(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return 0;
        }
    }

    private static char numToChar(long n) {
        switch ((int) n) {
            case 1:
                return 'A';
            case 2:
                return 'C';
            case 3:
                return 'G';
            case 4:
                return 'T';
            default:
                return 'N';
        }
    }
}
