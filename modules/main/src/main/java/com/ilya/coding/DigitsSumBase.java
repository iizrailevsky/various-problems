package com.ilya.coding;

/**
 * Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.
 *
 * After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.
 *
 * Input: n - base 10 number, k - new base to convert the number to
 * Output: each digit in the converted number sumed up and returned in base 10
 * Constraints: 1 <= n <= 100, 2 <= k <= 10
 * Options: Mod base k the number n, then divide n by k.
 *          Sum up the digits.
 */
public class DigitsSumBase {

    public static int sumBase(int n, int k) {
        // error checking
        if (n < 1 || n > 100 || k < 1 || k > 10) {
            return -1;
        }

        int sumDigits = 0;
        int digit;
        // keep mod'ing and dividing n by k
        while (n != 0) {
            digit = n % k;
            n = n / k;
            sumDigits += digit;
        }

        return sumDigits;
    }
    public static int sumBaseSlow(int n, int k) {
        // error checking
        if (n < 1 || n > 100 || k < 1 || k > 10) {
            return -1;
        }

        int sumDigits = 0;
        int digit;
        int numBase = 0;
        int order = 1;
        // keep mod'ing and dividing n by k
        while (n != 0) {
            digit = n % k;
            numBase += digit * order;
            order *= 10;
            n = n / k;
        }

        // convert from numBase to base 10 digits and sum them up
        while (numBase != 0) {
            digit = numBase % 10;
            sumDigits += digit;
            numBase = numBase / 10;
        }

        return sumDigits;
    }
}
