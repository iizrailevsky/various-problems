package com.ilya.coding;

import java.util.*;

/**
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order
 * left to right, bottom to top.
 * Input: List<List<Integer>> nums
 * Output: all elements in left to right, bottom to top order: int[]
 * Constraints: int max in one machine, positive int elements
 * Example: nums = [[1,2,3], [4,5,6], [7,8,9]]. Output: [1,4,2,7,5,3,8,6,9]
 * Options: Create matrix double array. # rows (n) - size of array, # cols (m) - max sub-array length.
 *          Initialize matrix with elements.
 *          Iterate in order: i: 0-n, in-loop: i: i to 0, j: 0 to m
 *          Time: O(n*m), Space: O(n*m)
 */
public class MatrixDiagonalOrder {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        // error checking
        if (nums == null || nums.isEmpty()) {
            return new int[] {};
        }

        // init n (# rows) and m (# cols)
        int n = nums.size();
        int m = getM(nums);
        int[][] arr = new int[n][m];
        List<Integer> res = new ArrayList<>();

        // init matrix
        initMatrix(arr, nums);

        // iterate in left to right, bottom to top order
        // for left-top half
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (int k = i; k >= 0; k--) {
                if (j < m && arr[k][j] != 0) {
                    res.add(arr[k][j]);
                }
                j++;
            }
        }

        // iterate in left to right, bottom to top order
        // for bottom-right half
        for (int j = 1; j < m; j++) {
            int l = j;
            for (int i = n - 1; i >= 0; i--) {
                if (l < m && arr[i][l] != 0) {
                    res.add(arr[i][l]);
                }
                l++;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getM(List<List<Integer>> nums) {
        int max = -1;
        for (List<Integer> row: nums) {
            max = Math.max(max, row.size());
        }
        return max;
    }

    private static void initMatrix(int[][] arr, List<List<Integer>> nums) {
        int i = 0;
        for (List<Integer> row: nums) {
            for (int j = 0; j < row.size(); j++) {
                arr[i][j] = row.get(j);
            }
            i++;
        }
    }
}
