package com.ilya.coding;

import java.util.Stack;

public class NumericPalindrome {
    public static boolean isNumericPalindrome(long number) {
        // error checking
        if (number < 0) {
            return false;
        }

        // init variables
        Stack<Integer> stack = new Stack<>();
        int length = (int)(Math.log10(number) + 1);
        boolean odd = (length % 2) != 0 ? true : false;
        int half = odd ? length / 2 + 1 : length / 2;

        if (length == 1) {
            return true;
        }

        // add to stack half of digits
        for (int i = 0; i < half && number > 0; i++) {
            stack.push((int)(number % 10));
            number /= 10;
        }

        // remove middle number if odd number of digits
        if (odd) {
            stack.pop();
        }

        // match rest of digits to previous ones
        while (number > 0 && !stack.empty()) {
            // not matching?
            if ((number % 10) != stack.pop()) {
                return false;
            }
            number /= 10;
        }

        return true;

    }
}
