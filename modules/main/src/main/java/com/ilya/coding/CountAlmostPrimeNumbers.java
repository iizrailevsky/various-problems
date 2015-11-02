package com.ilya.coding;

public class CountAlmostPrimeNumbers {

    public static int countAlmostPrimeNumbers(int from, int to) {
        /*
          A prime number is a natural number that has exactly two distinct natural number divisors,
          which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13.

          Almost prime numbers are the non-prime numbers
          which are divisible by only a single prime number.

          Please implement this method to
          return the number of almost prime numbers within the given range (inclusively).
         */
         int count = 0;
         for (int num = from; num <= to; num++) {
         	for (int i = 2; i <= num/2; i++) {
         		if ((num % i) == 0) {

         		}
         	}
         }
        return count;
    }
}
