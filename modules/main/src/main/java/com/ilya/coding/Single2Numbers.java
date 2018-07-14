package com.ilya.coding;

public class Single2Numbers {

    /**
     * Array of numbers. Exactly 2 numbers appear only once, others exactlyn twice.
     * Return array of 2 numbers appearing only once
     * Example: [1 2 1 3 2 5]
     * Output: [3 5]
     */
    public static int[] getTwoSingleNumbers(int[] a) {
        if (a == null || a.length < 2) {
            return null;
        }

        // first XOR of all the numbers and XOR of 2 distinct numbers
        int diff = 0;
        for (int i : a) {
            diff ^= i;
        }
        // extract the rightmost bit that differs between the 2 distinct numbers
        diff &= -diff;

        int [] res = new int[2];
        // now XOR to find the number that has the rightmost bit set
        // and the one that does not
        for (int i : a) {
            if ( (i & diff) == 0) { // the rightmost bit is NOT set
                res[0] ^= i;
            } else {                // the rightmost bit IS set
                res[1] ^= i;
            }
        }

        return res;
    }
}
