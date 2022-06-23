package com.ilya.coding;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * You are currently designing a dynamic array. You are given a 0-indexed integer array nums,
 * where nums[i] is the number of elements that will be in the array at time i.
 * In addition, you are given an integer k, the maximum number of times you can resize the array (to any size).
 *
 * The size of the array at time t, sizet, must be at least nums[t] because there needs to be enough space
 * in the array to hold all the elements. The space wasted at time t is defined as sizet - nums[t], and
 * the total space wasted is the sum of the space wasted across every time t where 0 <= t < nums.length.
 *
 * Return the minimum total space wasted if you can resize the array at most k times.
 *
 * Note: The array can have any size at the start and does not count towards the number of resizing operations.
 *
 * Input: int[] nums - the number of elements that will be in the array at time i
 *        int k - the maximum number of times you can resize the array (to any size)
 * Output: int -  the minimum total space wasted if you can resize the array at most k times
 *         Space wasted at time t is defined as sizet - nums[t]
 * Constraints: 1 <= nums.length <= 200
 *              1 <= nums[i] <= 106
 *              0 <= k <= nums.length - 1
 * Examples:
 *  A. Input: nums = [10,20], k = 0
 *     Output: 10
 *     Explanation: size = [20,20]. We can set the initial size to be 20. The total wasted space is (20 - 10) + (20 - 20) = 10
 *  B. Input: nums = [10,20,30], k = 1
 *     Output: 10
 *     Explanation: size = [20,20,30]. We can set the initial size to be 20 and resize to 30 at time 2.
 *     The total wasted space is (20 - 10) + (20 - 20) + (30 - 30) = 10.
 *  C. Input: nums = [10,20,15,30,20], k = 2
 *     Output: 15
 *     Explanation: size = [10,20,20,30,30]. We can set the initial size to 10, resize to 20 at time 1, and resize to 30 at time 3.
 *     The total wasted space is (10 - 10) + (20 - 20) + (20 - 15) + (30 - 30) + (30 - 20) = 15.
 *
 *  Options: Add elements to a sorted set SortedSet<Integer>. Initialize size[i] with max.
 *          Calculate minSpaceWasted at i: for [i...n=1] sum(size[i]-nums[i]).
 *          Recursively at i and k resizing left, calculate minSpaceWasted at i and try next max (< previous max)
 */
public class MinSpaceWastedKResizing {

    public static int minSpaceWastedKResizing(int[] nums, int k) {
        // error checking
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }

        // generate sorted set of the numbers in desc order
        Set<Integer> sorted = getSortedSet(nums);
        int n = nums.length;
        int maxNum = sorted.iterator().next();
        // remove top from sorted set
        sorted.remove(maxNum);

        int minSpaceWasted = minSpaceWastedRec(nums, maxNum, sorted, 0, n, k);

        return minSpaceWasted;
    }

    private static int minSpaceWastedRec(int[] nums, int maxNum, Set<Integer> sorted, int ind, int n, int k) {
        // base cases
        if (ind >= n) {
            return 0;
        } else if (ind == n - 1 && k == 0) {
            return maxNum - nums[ind];
        }

        int minSpaceWasted = maxNum - nums[ind] + minSpaceWastedRec(nums, maxNum, sorted, ind + 1, n, 0);
        int minSW;
        // if k > 0, try alternative sizings
        if (k > 0) {
            for (int size: sorted) {
                minSW = size - nums[ind] + minSpaceWastedRec(nums, maxNum, sorted, ind + 1, n, k - 1);
                minSpaceWasted = Math.min(minSpaceWasted, minSW);
            }
        }

        return minSpaceWasted;
    }

    private static Set<Integer> getSortedSet(int[] nums) {
        Set<Integer> sorted = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int num: nums) {
            sorted.add(num);
        }

        return sorted;
    }
}
