package com.ilya.coding;

public class PrimeCounting {

    // The sieve of Eratosthenes solution
    public static int primeCounting(int n) {
        // error checking
        if (n <= 1) {
            return 0;
        }

        // init variables
        // by default all are prime numbers
        boolean[] notPrime = new boolean[n + 1];
        int numOfPrimes = 0;

        // go over numbers 2 to n, and mark non-prime numbers
        for (int i = 2; i <= n; i++) {
            // prime? count it
            if (!notPrime[i]) {
                numOfPrimes++;

                // remove all the multiples of this prime
                for (long j = (long)i * i; j <= n; j += i) {
                    notPrime[(int)j] = true;
                }
            }
        }

        return numOfPrimes;
    }
}
