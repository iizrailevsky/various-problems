package com.ilya.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 *
 * Input: n - Length of strings
 * Output: count of various string
 * Constraints: 1 <= n <= 50
 * Examples:
 *      1: Input: n = 1, Output: 5, The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 *      2: Input: n = 2, Output: 15, The 15 sorted strings that consist of vowels only are
 *              ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 *              Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 *      3: n = 33, Output: 66045
 * Options: Recursively go over the possible vowel characters until reach the n total characters in length.
 *          Make sure that the considered characters are >= than the last character used.
 *          Time: O(n!), Space:
 */
public class CountVowelStrings {

    private static final Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static int countVowelStrings(int n) {
        // error checking
        if (n <= 0) {
            return 0;
        }

        // recursively go over the possible vowel characters and count
        return count(n, '_');
    }

    /**
     * Counts
     * @param n
     * @param lastChar
     * @return
     */
    private static int count(int n, char lastChar) {
        // reached end of the string? return 1 count
        if (n <= 0) {
            return 1;
        }

        int count = 0;

        // go over the vowels and make sure the next character is >= than the last character
        for (char c: vowels) {
            if (c >= lastChar) {
                count += count(n - 1, c);
            }
        }

        return count;
    }
}
