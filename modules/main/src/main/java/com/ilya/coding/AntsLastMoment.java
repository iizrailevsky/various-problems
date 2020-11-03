package com.ilya.coding;
/**
 *We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves  *with speed 1 unit per second. Some of the ants move to the left, the other move to the right.
 *
 * When two ants moving in two different directions meet at some point, they change their directions * and continue moving again. Assume changing directions doesn't take any additional time.
 *
 * When an ant reaches one end of the plank at a time t, it falls out of the plank imediately.
 *
 *Given an integer n and two integer arrays left and right, the positions of the ants moving to the *left and the right. Return the moment when the last ant(s) fall out of the plank.
 */
public class AntsLastMoment {
    public static int getLastMoment(int n, int[] left, int[] right) {
        // error checking
        if (n < 0) {
            return 0;
        }

        // go over time
        // decrement left set positions and increment right positions
        int t = 0;
        while (isNotEmpty(n, left) || isNotEmpty(n, right)) {
            for (int i = 0; i < left.length; i++) {
                left[i]--;
            }
            for (int j = 0; j < right.length; j++) {
                right[j]++;
            }
            t++;
        }

        return t - 1;
    }

    /**
     * Returns true if the given array of positions
     * is still not empty, false otherwise
     */
    private static boolean isNotEmpty(int n, int[] a) {
        for (int i = 0; i < a.length; i++) {
            // positions array is not empty
            // if the positions are valid
            if (a[i] >= 0 && a[i] <= n) {
                return true;
            }
        }
        return false;
    }
}
