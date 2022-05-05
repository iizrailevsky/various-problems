package com.ilya.coding;

/**
 * Implements basic string compression using counts of repeated characters.
 * Input: s - String
 * Output: compressed s using counts of repeated characters
 * Constraints: Only uppercase or lowercase letters
 * Example: "aabcccccaaa" -> "a2b1c5a3"
 * Options: For each character from the beginning, count number of further occurrences.
 *          Record this in the output result res string.
 *          If the compressed string is not smaller in length than the original, then return the original one.
 *          Time: O(n), Space: O(n)
 */
public class StringCompression {

    public static String compress(String s) {
        // error checking
        if (s == null || s.isEmpty()) {
            return s;
        }

        // init vars
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;
        int j;

        // go over the string and count repeated characters
        while (i < chars.length) {
            char c = chars[i];
            j = i + 1;
            while (j < chars.length && chars[j] == c) {
                j++;
            }
            // add compressed numbers
            sb.append(c).append(j-i);
            // move i forward
            i = j;
        }

        // check if the compressed string is smaller
        // if not - then return the original one
        if (s.length() < sb.length()) {
            return s;
        }

        return sb.toString();
    }

}
