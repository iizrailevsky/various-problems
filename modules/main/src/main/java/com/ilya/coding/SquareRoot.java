package com.ilya.coding;

public class SquareRoot {

    public static int sqrt(int n) {
        // error checking
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        }

        // init variables
        int lowerBound = 1;
        int upperBound = n;
        int x = lowerBound + (upperBound - lowerBound) / 2;

        // do binary search to find root x
        while (x > n / x || (x + 1) <= n / (x + 1)) {
            if (x > n / x) {
                upperBound = x;
            } else {
                lowerBound = x;
            }

            x = lowerBound + (upperBound - lowerBound) / 2;
        }

        return x;
    }
}
