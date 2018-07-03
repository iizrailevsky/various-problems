package com.ilya.coding;

import java.util.*;

public class BinaryContiguousArray {

    // returns the maximum length of a contiguous subarray with equal number of 0 and 1
    public static int findMaxLength(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // init vars
        int n = nums.length;
        int maxLength = 0;
        // running sum counts
        int[] counts = new int[n];
        // map of sum to index
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        // init sum of 0 to index of -1
        sumToIndex.put(0, -1);

        // calculate running sum
        calculateRunningSum(nums, n, counts);

        // find max length subarray where the same sum (point)
        // occurs more than once
        for (int i = 0; i < n; i++) {
            if (sumToIndex.containsKey(counts[i])) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(counts[i]));
            } else {
                sumToIndex.put(counts[i], i);
            }
        }

        return maxLength;
    }

    private static void calculateRunningSum(int[] nums, int n, int[] counts) {
        // calculate running sum
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                counts[i] = counts[i - 1];
            }
            if (nums[i] == 1) {
                counts[i]++;
            } else {
                counts[i]--;
            }
        }
    }
}
