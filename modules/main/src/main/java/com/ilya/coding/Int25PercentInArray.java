package com.ilya.coding;

/**
 * Given an interger sorted in non-decreasing order,
 * find the integer that occurs >25%.
 *
 * Input: int[] arr
 * Output: int that occurs >25%
 * Constraints: lenth in memory of one machine, positive ints
 * Options: Bruce force: For each int in array, count
 *          how many time it occurs. If count/size > 0.25,
 *          then return this int.
 *          Time: O(N^2), Space: O(1)
 *          Optimized: For each int, start count of index,
 *          keep going until new int is found. Check if
 *          (curInd - startInd) / size > 0.25, then return this int.
 *          Time: O(N), Space: O(1)
 */
public class Int25PercentInArray {
    public static int findSpecialInteger(int[] arr) {
        // error checking
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int size = arr.length;
        int startInd = 0;
        int curInt = arr[0];

        // go over array and find int occurring >0.25
        for (int i = 1; i < size; i++) {
            // new int? check length
            if (arr[i] != curInt) {
                if (((float)(i - startInd) / size) > 0.25) {
                    return curInt;
                }
                // restart count
                curInt = arr[i];
                startInd = i;
            }
        }

        // check end of array case
        if (((float)(size - startInd) / size) > 0.25) {
            return curInt;
        }

        return -1;
    }
}
