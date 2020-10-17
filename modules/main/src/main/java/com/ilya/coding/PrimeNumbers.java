package com.ilya.coding;

import java.util.*;

public class PrimeNumbers {

    public static List<Integer> getPrimeNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all prime numbers in the given range (inclusively).
          A prime number is a natural number that has exactly two distinct natural number divisors, which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13
         */
         List<Integer> result = new ArrayList<Integer>();
         for (int num = from; num <= to; num++) {
         	boolean isPrime = true;
         	for (int i = 2; i <= num/2; i++) {
         		if ((num % i) == 0) {
         			isPrime = false;
         			break;
         		}
         	}
         	if (isPrime) {
         		result.add(num);
         	}
         }
         return result;
    }

	/**
	 * Prints n prime numbers, starting from 2
	 * @param n Number of primes to print
	 */
	public static void printNPrimes(int n) {
    	// error checking
		if (n <= 0) {
			return;
		}

		for (int num = 2; n > 0; num++) {
			boolean isPrime = true;
			for (int i = 2; i <= num/2; i++) {
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				System.out.println(num);
				n--;
			}
		}
	}

	public static void main(String[] args) {
		printNPrimes(10);
	}
}
