package com.ilya.coding;

import java.util.*;
import java.util.Stack;

/**
 * Merge two lists of intervals sorted by first element.
 * Interval (a, b) => starts at start, ends at end inclusive.
 * Input: 2 lists of intervals
 * Output: merged list of intervals
 * Example: [(1, 4), (5, 10), (15, 19), (30, 31)] length n
 * [(2, 20), (27, 29)] length m
 * Expected output => [(1, 20), (27, 29), (30, 31)]
 * (1, 20) is derived from => (1, 4) , (5, 10) , (15, 19) ], (2, 20)
 * Option: Set array with starts as 1 and ends as -1 from intervals.
 *         Go over the array and add to stack: push at 1 and pop at -1.
 *         If stack is empty, add to the result list with start last
 *         element in stack and end as the -1 index.
 *         Complexity: Time = O(n+m), Space = O(n+m)
 */
public class MergeIntervalLists {
    public static List<Interval> mergeInervalLists(List<Interval> one, List<Interval> two) {
        // error checking
        if (one == null || two == null) {
            return new ArrayList<>();
        }

        // init vars
        List<Interval> out = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // get max end
        int lastEnd = getLastEnd(one, two);
        int[] range = new int[lastEnd + 1];

        // populate range
        populateRange(range, one, two);

        // merge intervals
        for (int i = 0; i <= lastEnd; i++) {
            // start?
            if (range[i] > 0) {
                while (range[i] > 0) {
                    stack.push(i);
                    range[i]--;
                }
            } else if (range[i] < 0) {
                int start = 0;
                while (range[i] < 0) {
                    start = stack.pop();
                    range[i]++;
                }
                // last end of range? add to out list
                if (stack.isEmpty()) {
                    out.add(new Interval(start, i));
                }
            }
        }

        return out;
    }

    /**
     * Returns last end
     * @param one
     * @param two
     * @return
     */
    private static int getLastEnd(List<Interval> one, List<Interval> two) {
        int lastEnd = -1;

        for (Interval i : one) {
            if (i.end > lastEnd) {
                lastEnd = i.end;
            }
        }
        for (Interval i : two) {
            if (i.end > lastEnd) {
                lastEnd = i.end;
            }
        }

        return lastEnd;
    }

    /**
     * Populates range
     * @param range
     * @param one
     * @param two
     */
    private static void populateRange(int[] range, List<Interval> one, List<Interval> two) {
        for (Interval i : one) {
            range[i.start]++;
            range[i.end]--;
        }
        for (Interval i : two) {
            range[i.start]++;
            range[i.end]--;
        }
    }


}
