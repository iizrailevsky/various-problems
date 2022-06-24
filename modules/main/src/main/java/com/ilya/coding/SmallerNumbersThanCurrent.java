package com.ilya.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // clone the array and sort in asc order
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);

        // create and populate Map<num, count>
        int n = numsCopy.length;
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            // add num and index
            numToCountMap.put(numsCopy[i], i);
        }

        // populate the output array
        int[] outCount = new int[n];
        for (int i = 0; i < n; i++) {
            outCount[i] = numToCountMap.get(nums[i]);
        }

        return outCount;
    }
}
