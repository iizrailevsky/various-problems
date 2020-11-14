package com.ilya.coding;

import java.util.*;

/**
 * Given a list of intervals, remove all intervals that are covered by
 * another interval in the list. Return the number of remaining intervals.
 * Interval [a,b) is covered by interval [c, d) if and only if c <= a and b <= d
 *
 * Input: array of intervals: int[][]
 * Output: number of remaining intervals: int
 *
 * Exampe: intervals = [[1,4], [3,6], [2,8]]
 *         Output: 2 -> [3,6] get covered by [2,8]
 * Options: Create an array with max number.
 *          Set numbers by interval number in the array.
 *          Calculate number of unique numbers at the end
 *          Time: O(n), Space: O(n)
 */
public class IntervalsRemoveCovered {
    public static int removeCoveredIntervals(int[][] intervals) {
        // error checking
        if (intervals == null) {
            return 0;
        }

        // find max range integer
        int max = getMaxRange(intervals);

        int[] range = new int[max + 1];

        // set interval numbers in range array
        setIntervalNums(range, intervals);

        // calculate unique number of intervals nums left
        return getUniqueIntervalNums(range);
    }

    // find max range integer
    private static int getMaxRange(int[][] intervals) {
        int max = -1;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
        }

        return max;
    }

    // set interval numbers in range array
    private static void setIntervalNums(int[] range, int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            // set interval range unless it's fully convered by another range
            int start = intervals[i][0];
            int end = intervals[i][1];
            if ((range[start] == 0 && range[end] == 0) || (range[start] != range[end])) {
                for (int j = start; j <= end; j++) {
                    // interval numbers start from 1 and on
                    range[j] = i + 1;
                }
            }

        }
    }

    // calculate unique number of intervals nums left
    private static int getUniqueIntervalNums(int[] range) {
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < range.length; i++) {
            if (range[i] != 0) {
                if (!unique.contains(range[i])) {
                    unique.add(range[i]);
                }
            }
        }

        return unique.size();
    }
}
