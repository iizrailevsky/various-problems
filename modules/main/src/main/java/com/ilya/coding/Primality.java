package com.ilya.coding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Primality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println((isPrime(n)) ? "Prime" : "Not prime");
        }
    }

    // returns true if a given number is prime, false otherwise
    private static boolean isPrime(int n) {
        // error checking
        if (n <= 1) {
            return false;
        }
        if (n == 2 && n == 3) {
            return true;
        }

        // init variables
        boolean isPrime = true;
        int sqrtOfN = (int)Math.sqrt((double)n);
        for (int i = 2; i <= sqrtOfN; i++) {
            if ((n % i) == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
