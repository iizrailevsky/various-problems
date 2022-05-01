package com.ilya.coding;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x
 * where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.
 *
 * The score of nums is the difference between the maximum and minimum elements in nums.
 *
 * Return the minimum score of nums after applying the mentioned operation at most once for each index in it.
 *
 * Input: int[] nums, int k
 * Score(nums) = max(nums[...]) - min(nums[...])
 * Output: Min score of nums after applying at most once for each index
 * Constraints: 1 <= nums.length <= 104
 *              0 <= nums[i] <= 104
 *              0 <= k <= 104
 * Example: [7, 0, 3, 5, 11, 13, 3], k = 50
 *              a = 0, b = 13, Med(a, b) = 6
 * Options 1: Find min and max in nums. Calculate mid range between min and max = (max - min) / 2
 *            If k <= mid, apply min + mid, max - mid
 *            Else apply min += mid, max -= mid
 *            Time = O(n), Space = O(n)
 *
 */
public class SmallestRangeI {
    public static int smallestRangeI(int[] nums, int k) {
        // error checking
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }

        int minScore = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // find min and max in the array
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // calculate mid range
        int mid = (max - min) / 2;

        // calculate min score by applying k to min and max
        if (k < mid) {
            // apply at least k to max and min
            minScore = (max - k) - (min + k);
        } else if (k == mid) {
            // apply mid or (mid - 1)
            minScore = (max - mid) - (min + mid);
        } else {
            // k > mid, then apply mid or (mid + 1) which would make minScore = 0
            minScore = 0;
        }

        return minScore;
    }
}
