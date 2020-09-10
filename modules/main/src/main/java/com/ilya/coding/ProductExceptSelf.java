package com.ilya.coding;

/**
 *  Product of Array Except Self
 *  Given array nums of n integers where n > 1, return array output that output[i]
 *  is equal to the product of all the elements in nums, except nums[i]
 *
 *  Input: nums[] array of ints
 *  Output: int[] output
 *  Constraints: 32-bit integer
 *  Example: Input: [1, 2, 3, 4]
 *           Output: [24, 12, 8, 6]
 *
 *  Options:
 *    - Brute force: For each element, go over all other elements and multiply them
 *      Time: O(N^2), Space: O(1)
 *    - Optimized: Calculate L[] with product of nums to the left initialized at 1,
 *                 calculate R[] with product of nums to the right initialized at 1,
 *                 populate output[] by multiplying L[] and R[] at each position i.
 *
 */

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        // error checking
        if (nums == null || nums.length < 2) {
            return null;
        }

        // init variables
        int n = nums.length;
        int[] L = new int[n];
        L[0] = 1;
        int[] R = new int[n];
        R[n - 1] = 1;
        int[] output = new int[n];

        // calculate L[] with product of nums to the left initialized at 1
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        // calculate R[] with product of nums to the right initialized at 1
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        // populate for each element
        for (int i = 0; i < n; i++) {
            output[i] = L[i] * R[i];
        }

        return output;
    }
}
