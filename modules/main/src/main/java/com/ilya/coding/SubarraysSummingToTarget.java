package com.ilya.coding;

import java.util.*;

public class SubarraysSummingToTarget {

    public static List<List<Integer>> findSubarraysSummingToTarget(int[] a, int target) {
        // error checking
        if (a == null || a.length == 0) {
            return null;
        }

        int[] runningSum = genRunningSum(a);
        List<List<Integer>> resultPairs = findSubarrayInds(runningSum, target);

        return resultPairs;
    }

    private static int[] genRunningSum(int[] a) {
        int n = a.length;
        int[] runningSum = new int[n];

        // init 1st
        runningSum[0] = a[0];
        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i - 1] + a[i];
        }

        return runningSum;
    }

    private static List<List<Integer>> findSubarrayInds(int[] runningSum, int target) {
        List<List<Integer>> resultPairs = new ArrayList<>();
        int n = runningSum.length;
        Map<Integer, List<Integer>> runningSumToInds = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // found exact target sum? from 0 to i
            if (runningSum[i] == target) {
                resultPairs.add(Arrays.asList(0, i));
            }

            int reqPrevRunningSum = runningSum[i] - target;
            // found previous running sum where current running sum - target?
            // from previous running sum index + 1 to i
            if (runningSumToInds.containsKey(reqPrevRunningSum)) {
                List<Integer> startInds = runningSumToInds.get(reqPrevRunningSum);
                for (int startInd : startInds) {
                    resultPairs.add(Arrays.asList(startInd + 1, i));
                }
            }

            // add to map
            if (runningSumToInds.containsKey(runningSum[i])) {
                List<Integer> inds = runningSumToInds.get(runningSum[i]);
                inds.add(i);
            } else {
                List<Integer> inds = new ArrayList<>();
                inds.add(i);
                runningSumToInds.put(runningSum[i], inds);
            }
        }

        return resultPairs;
    }
}
