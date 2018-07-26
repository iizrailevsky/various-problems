package com.ilya.coding;

public class ModifiedPalindrome {

    /**
     * Given a string s, find if it's a palindrome,
     * with allowing one modification - replace / add / remove
     * @param s
     * @return
     */
    public static boolean isModifPalindrome(String s) {
        // error checking
        if (s == null) {
            return false;
        }

        return isModifPalindrome(s, true);
    }

    private static boolean isModifPalindrome(String s, boolean isModifAllowed) {
        // error checking
        if (s == null) {
            return false;
        }

        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1) || isModifAllowed) {
                return true;
            } else {
                return false;
            }
        }

        int leftInd = 0;
        int rightInd = s.length() - 1;
        char leftC = s.charAt(leftInd);
        char rightC = s.charAt(rightInd);

        if (leftC == rightC) {
            return isModifPalindrome(s.substring(leftInd + 1, rightInd), isModifAllowed);
        } else {
            return isModifAllowed &&
                    // replace left with right and try
                    (isModifPalindrome(rightC + s.substring(leftInd + 1, rightInd + 1), false) ||
                    // prepend right before left
                    isModifPalindrome(rightC + s.substring(leftInd, rightInd + 1), false) ||
                    // append left after right
                    isModifPalindrome(s.substring(leftInd, rightInd + 1) + leftC, false)
                    );
        }
    }
}
