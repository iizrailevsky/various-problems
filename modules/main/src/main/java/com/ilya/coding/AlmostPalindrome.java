package com.ilya.coding;

// Given a string input determine if you can make it a palindrome by removing at most 1 character.

// Examples:

// isAlmostPalindrome("aba") => True
// isAlmostPalindrome("abcabc") => False
// isAlmostPalindrome("abcbca") => True
// >> a[b]cbca → acbca, abcb[c]a → abcba
//
// Input: String input
// Output: boolean if the string is a palindrome
// or it can be made into a palindrome by removing
// 1 character
// Constraints: Any unicode character string
// Options: Go over chars from start and end,
// if the same char, then recursively check rest of string in between.
// Else try removing either start or end char, and recursively check the rest
// Time: O(n) Space: O(n)

public class AlmostPalindrome {

    public static boolean isAlmostPalindrome(String input) {
        // error checking
        if (input == null || input.isEmpty() || input.length() == 1) {
            return true;
        }

        return isAlmostPalindrome(input, true);
    }

    private static boolean isAlmostPalindrome(String in, boolean canSkipChar) {
        // base case
        if (in.isEmpty() || in.length() == 1) {
            return true;
        }

        char start = in.charAt(0);
        char end = in.charAt(in.length() - 1);

        if (start == end) {
            return isAlmostPalindrome(in.substring(1, in.length() - 1), canSkipChar);
        } else if (canSkipChar) {
            return isAlmostPalindrome(in.substring(1, in.length()), false) ||
                    isAlmostPalindrome(in.substring(0, in.length() - 1), false);
        }

        return false;
    }

}
