package com.ilya.coding;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:

 * 1. Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.
 * 2. Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
 * 3. Reduce nums[i] to nextLargest.
 *
 * Return the number of operations to make all elements in nums equal.
 *
 * Input: nums - array of positive integers
 * Output: number of operations to reduce to all equal values.
 * Options: Add nums to a SortedMap<Int(num), Int(occurrences)>. While there're > 1 element
 *          left in the SortedMap, move top element to next one, add its occurrrences to
 *          the next one and total operations count.
 *          Time: O(n * log n), Space: O(n)
 */
public class ReductionOperations {
    public static int reductionOperations(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // init vars
        int totalOps = 0;
        // create and populate sorted map
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (int num: nums) {
            Integer numOcurs = sortedMap.get(num);
            if (numOcurs == null) {
                sortedMap.put(num, 1);
            } else {
                sortedMap.put(num, numOcurs + 1);
            }
        }

        // continue reducing until all are in one element
        while (sortedMap.size() > 1) {
            int top = 0;
            int nextTop = 0;
            int topVal = 0;
            int nextTopVal = 0;
            // move top element to next one
            int i = 0;
            for (Map.Entry<Integer, Integer> entry: sortedMap.entrySet()) {
                if (i == 0) {
                    top = entry.getKey();
                    topVal = entry.getValue();
                } else if (i == 1 && top != 0 && topVal != 0) {
                    // add its occurrrences to the next one
                    nextTop = entry.getKey();
                    nextTopVal = entry.getValue();
                    entry.setValue(nextTopVal + topVal);
                    // add its occurrences to the total operations count
                    totalOps += topVal;
                }
                i++;
                if (i > 1) {
                    break;
                }
            }
            // remove the top value
            sortedMap.remove(top);
        }

        return totalOps;
    }
}
