package com.ilya.coding;

import java.util.*;

public class PrimeFactors {

    public static List<Long> findAllPrimeFactors(long n) {
        // error checking
        if (n < 1) {
            return null;
        }

        // init variables
        List<Long> result = new ArrayList<>();

        // go over the prime numbers until sqrt of n
        for (long i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                result.add(i);
                n = n / i;
            }
        }

        if (n != 1) {
            result.add(n);
        }

        return result;
    }

    // if Gi is the number of factors in the i-th prime group,
    // there will be (G1 + 1) * (G2 + 1) * ... * (Gk + 1)
    // different ways to choose factors from the groups
    public static int countNumbersFactors(long n) {
        // error checking
        if (n < 1) {
            return 0;
        }

        // get all prime factors
        List<Long> allPrimeFactors = findAllPrimeFactors(n);

        if (allPrimeFactors == null || allPrimeFactors.size() == 0) { return 1; }
        if (allPrimeFactors.size() == 1) { return 2; }

        // init variables
        long a = allPrimeFactors.get(0);
        long b = -1;
        int totalCount = 1;
        int count = 2;
        // calculate Gi for each prime factor
        for (int i = 1; i < allPrimeFactors.size(); i++) {
            b = allPrimeFactors.get(i);
            if (a == b) {
                count++;
            } else {
                totalCount *= count;
                count = 2;
            }
            a = b;
        }

        totalCount *= count;

        return totalCount;
    }
}
