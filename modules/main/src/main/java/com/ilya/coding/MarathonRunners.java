package com.ilya.coding;

import java.util.*;

public class MarathonRunners {

    /**
     * Input: [1 3 0 -1] <- order
     *         0 1 2  3  <- runners
     *
     * Output: [3 1 0 2] <- runners
     *          0 1 2 3  <- order
     * @param a
     * @return
     */
    public static int[] orderRunners(int[] a) {
        // error checking
        if (a == null || a.length == 0) {
            return null;
        }

        Map<Integer, Integer> orderToRunner = generateMap(a);
        int[] runners = calcRunnerOrder(orderToRunner);
        return runners;
    }

    private static Map<Integer, Integer> generateMap(int[] a) {
        Map<Integer, Integer> orderToRunner = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            orderToRunner.putIfAbsent(a[i], i);
        }
        return orderToRunner;
    }

    private static int[] calcRunnerOrder(Map<Integer, Integer> orderToRunner) {
        int[] res = new int[orderToRunner.size()];

        // init 1st
        res[0] = orderToRunner.get(-1);
        for (int i = 1; i < orderToRunner.size(); i++) {
            res[i] = orderToRunner.get(res[i - 1]);
        }

        return res;
    }
}

