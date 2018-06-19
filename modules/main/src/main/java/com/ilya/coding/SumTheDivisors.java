package com.ilya.coding;

import java.util.*;

public class SumTheDivisors {

    public static long sumTheDivisors(int n) {
        // error checking
        if (n <= 0) {
            return -1;
        }

        // init variables
        long sum = 0;
        long possibleDiv;
        Set<Long> divisors = new HashSet<>();

        // go over possible divisors from 1 to sqrt of N
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                possibleDiv = n / i;
                if (n % possibleDiv == 0) {
                    divisors.add(possibleDiv);
                }
            }
        }

        for (long div: divisors) {
            sum += div;
        }

        return sum;
    }
}
