package com.ilya.coding;

import java.util.*;

/** Find common elements from all sorted integer arrays.
 * Input: List<List<Integer>> arr
 * Output: List<Integer> common elements
 * Example:
 *  int[] a1 = {1, 3, 4, 5, 7, 8, 10, 14}
 *  int[] a2 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
 *  int[] a3 = {2, 3, 5, 7, 9, 11}
 *  Output: int[] result = {3, 5, 7}
 *
 *  Options: Create Set<Integer>'s for all but 1st list
 *           Go over 1st list, check if each element
 *           exists in all other sets. If so, add to result set
 *           Time: O(M*N)
 *           Space: O(M*N)
 */
public class CommonListElements {
    public static List<Integer> getCommonElements(List<List<Integer>> arr) {
        // error checking
        if (arr == null || arr.isEmpty() || arr.size() == 1) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // store sets of elements
        List<Set<Integer>> sets = getSets(arr);

        // go over 1st list
        List<Integer> firstList = arr.get(0);
        for (int i : firstList) {
            boolean isCommon = true;
            // check if each element exists in all other sets
            for (Set<Integer> set : sets) {
                if (!set.contains(i)) {
                    isCommon = false;
                    break;
                }
            }
            // If so, add to result set
            if (isCommon) {
                result.add(i);
            }
        }

        return result;
    }

    private static List<Set<Integer>> getSets(List<List<Integer>> arr) {
        List<Set<Integer>> sets = new ArrayList<>();
        int count = 0;
        for (List<Integer> l : arr) {
            if (count != 0) {
                Set<Integer> set = new HashSet<>();
                for (int i : l) {
                    set.add(i);
                }
                sets.add(set);
            }
            count++;
        }
        return sets;
    }

}
