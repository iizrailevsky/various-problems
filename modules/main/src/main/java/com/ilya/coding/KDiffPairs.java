package com.ilya.coding;

import java.util.*;

/**
 *  K-diff Pairs in an array.
 *  Given an integer array, find number of all unique k-diff pairs.
 *  K-diff pair is a pair of (i, j) with absolute diff of k: abs(a - b) = k
 *  Constraints: (i, j) and (j, i) are the same pair.
 *               Size of array <= 10,000
 *               Integers are in range of [-1e7, 1e7]
 *  Input: [3, 1, 4, 1, 5], k = 2
 *  Output: 2
 *  Explain: (1, 3) and (3, 5)
 *  Options:
 *    - Bruce force: for each element, search rest of array
 *      for another element with diff of k
 *      Time: O(N^2), Space: O(N)
 *    - Optimization: put elements in Map(val, count), then
 *      for each val, check if there exists element
 *      with (val + k). If k == 0, check count > 1.
 *      Add pair to result set with the lower number: (3, 5), (1, 3) as 3, 1
 *      Time: O(N), Space: O(N)
 *
 */
public class KDiffPairs {
    public static int findPairs(int[] nums, int k) {
        // error checking
        if (nums == null || nums.length == 0 || nums.length > 10000 || k < 0) {
            return 0;
        }

        // init vars
        Map<Integer, Integer> valCountMap = new HashMap<>();
        Set<Integer> uniquePairsLower = new HashSet<>();

        // add elements to the Map(val, count)
        for (int i = 0; i < nums.length; i++) {
            if (valCountMap.containsKey(nums[i])) {
                valCountMap.put(nums[i], valCountMap.get(nums[i]) + 1);
            } else {
                valCountMap.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: valCountMap.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();
            int pairVal = val + k;

            // found the pair with (val + diff)
            if (valCountMap.containsKey(pairVal)) {
                int pairCount = valCountMap.get(pairVal);
                if (k == 0) {
                    if (pairCount > 1) {
                        uniquePairsLower.add(val);
                    }
                } else {
                    int lower = Math.min(val, pairVal);
                    uniquePairsLower.add(lower);
                }
            }
        }

        return uniquePairsLower.size();
    }
}
