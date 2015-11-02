package com.ilya.coding;

import java.util.Scanner;

public class CountWaysToJump {

    public CountWaysToJump() {
        // TODO Auto-generated constructor stub
    }

    private static int[] ways = new int[256];
    private static int count = 0;


    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        CountWaysToJump app = new CountWaysToJump();

        while (true) {
            // validate user input
            System.out.println( "Enter a step number: " );

            int N = 0;
            ways = new int[256];
            count = 0;
            if (sc.hasNext()) {
                N = sc.nextInt();
            } else {
                System.err.println( "Please enter valid Nth number" );
            }

            System.out.println( app.countWaysToJumpDP(N) );
        }

    }

    /**
     * Counts ways to jump to the step recursively
     * @param step
     * @return
     */
    public int countWaysToJumpRec(int step) {
        System.out.println("Count: " + count++);
        if (step < 0) {
            return 0;
        } else if (step == 0) {
            return 1;
        } else {
            return countWaysToJumpRec(step - 1)
                   + countWaysToJumpRec(step - 2)
                   + countWaysToJumpRec(step - 3);
        }
    }

    /**
     * Counts ways to jump to the step using dynamic programming
     * @param step
     * @return
     */
    public int countWaysToJumpDP(int step) {
        System.out.println("Count: " + count++);
        if (step < 0) {
            return 0;
        } else if (step == 0) {
            return 1;
        } else if (ways[step] > 0) {
            return ways[step];
        } else {
            ways[step] = countWaysToJumpDP(step - 1)
                        + countWaysToJumpDP(step - 2)
                        + countWaysToJumpDP(step - 3);
            return ways[step];
        }
    }



}
