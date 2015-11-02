package com.ilya.coding;

import java.util.Scanner;

public class Fibonacci {

    public Fibonacci() {
        // TODO Auto-generated constructor stub
    }

    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        Fibonacci app = new Fibonacci();

        while (true) {
            // validate user input
            System.out.println( "Enter a Nth Fibonacci number: " );

            int N = 0;
            fib = new int[256];
            count = 0;
            if (sc.hasNext()) {
                N = sc.nextInt();
            } else {
                System.err.println( "Please enter valid Fibonacci's Nth number" );
            }

            System.out.println( app.getNthFibonacciDP(N) );
        }

    }

    /**
     * Returns Nth Fibonacci number
     * @param N Fibonacci Nth number
     * @return Nth fibonacci number, -1 if not found
     */
    public long getNthFibonacci(int N) {
        // error checking
        if (N < 0) {
            throw new IllegalArgumentException("Fibonacci Nth number " + N + " is invalid ");
        }

        // base conditions
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 1;
        }

        // initialize variables
        int x = 1;
        int y = 1;
        int z = -1;
        for (int i = 3; i <= N; i++) {
            z = x + y;
            x = y;
            y = z;
        }

        return z;
    }

    /**
     * Returns Nth Fibonacci number using simple recursion
     * @param N
     * @return Nth Fibonacci number
     */
    public int getNthFibonacciRec(int N) {
        System.out.println("Count: " + count++);
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return getNthFibonacciRec(N - 1) + getNthFibonacciRec(N - 2);
        }
    }

    private static int[] fib = new int[256];
    private static int count = 0;

    /**
     * Returns Nth Fibonacci number using dynamic programming (caching)
     * @param N
     * @return Nth Fibonacci number
     */
    public int getNthFibonacciDP(int N) {
        System.out.println("Count: " + count++);
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (fib[N] > 0) {
            return fib[N];
        } else {
            fib[N] = getNthFibonacciDP(N - 1) + getNthFibonacciDP(N - 2);
            return fib[N];
        }
    }


}
