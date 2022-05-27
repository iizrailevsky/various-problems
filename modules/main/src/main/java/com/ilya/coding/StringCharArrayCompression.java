package com.ilya.coding;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 * Input: chars Character array
 * Output: New length of the array
 * Constraints: 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 * Examples:
 *  A. Input: chars = ["a","a","b","b","c","c","c"]
 *     Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 *     Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 *  B. Input: chars = ["a"]
 *     Output: Return 1, and the first character of the input array should be: ["a"]
 *     Explanation: The only group is "a", which remains uncompressed since it's a single character.
 *  C. Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 *     Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"]
 *     Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 *  Options: Go over the char array from the start, take given char and count its occurrences
 *           until find a different char. Maintain a StringBuilder and append the char and its
 *           count if > 1. Update the original array with chars from the StringBuilder and '\0'
 *           out the remaining characters. Return length of the StringBuilder.
 */
public class StringCharArrayCompression {
    public static int compress(char[] chars) {
        // error checking
        if (chars == null || chars.length == 0) {
            return 0;
        } else if (chars.length == 1) {
            // 1-char array - return 1 and leave the array as is
            return 1;
        }

        // init vars
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        int count = 0;
        int i = 0;
        int j;
        char c;

        // go over the array and count its chars
        while (i < length) {
            c = chars[i];
            count = 1;
            // count c's occurrences
            for (j = i + 1; j < length && chars[j] == c; j++) {
                count++;
            }
            // update StringBuilder with c and its count if > 1
            sb.append(c);
            if (count > 1) {
                sb.append(count);
            }
            // go to the next char
            i = j;
        }

        // update the original char array with the StringBuilder's chars
        int sbLength = sb.length();
        int k = 0;
        while (k < sbLength && k < length) {
            chars[k] = sb.charAt(k);
            k++;
        }
        // zero out the remainder of the char array
        while (k < length) {
            chars[k] = '\0';
            k++;
        }

        // return the new length of the array
        return sbLength;
    }
}
