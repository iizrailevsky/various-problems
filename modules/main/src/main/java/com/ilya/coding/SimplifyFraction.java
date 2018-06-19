package com.ilya.coding;

public class SimplifyFraction {

    public static void simplify_fraction(int numerator, int denominator, int[] result) {
        // Write your code here
        // result[0] = ...
        // result[1] = ...

        // error checking
        if (numerator <= 0 || denominator <= 0 || result == null || result.length != 2) {
            throw new IllegalArgumentException("invalid input!");
        }

        // init variables
        int gcd = gcdIter(numerator, denominator);

        result[0] = numerator / gcd;
        result[1] = denominator / gcd;
    }

    private static int gcd(int a, int b) {
        if (b > a) { return gcd(b, a); }
        if (b == 0) { return a; }
        return gcd(b, a % b);
    }

    private static int gcdIter(int a, int b) {
        if (b > a) { return gcdIter(b, a); }

        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
