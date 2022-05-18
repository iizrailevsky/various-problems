package com.ilya.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 *
 * Input: n Number of nodes with unique values from 1 to n
 * Output: Number of structurally unique BST's (binary search trees)
 * Constraints: 1 <= n <= 19
 * Example:
 *      1: Input: n = 1. Output: 1. Note: 1
 *      2: Input: n = 2. Output: 2. Note: 1 -> 2, 1 <- 2
 *      1: Input: n = 3. Output: 5. Note: 1 -> 2 -> 3, 1 -> 3 -> 2, 1 <- 2 -> 3, 1 <- 2 <- 3, [1 -> 2] <- 3
 * Options:
 *          Assuming we have n = 3, it is made of set {1,2,3}. Since we are constructing a BST,
 *          we could choose any node as the root and make another set of BSTs from the remaining of the nodes.
 *          So, let us pick up 1 as a root. We will have only one possibility of keeping {2,3} as the right nodes.
 *          So the solution for this part will be the no. of unique bsts for n=2
 *          Pick 2 as a root. We will have {1} and {3} as two bsts where each one will have only 1 solution.
 *          Pick 3 as a root. We will have {1,2} as the left children with a count = 2 for n=2.
 *          This leads to a recursive equation of :
 *
 *          T(n) = for(int i=1;i<=n;i++) {
 *                  //make each one a root.
 *                  val += T(i-1) * T(n-i);
 *                 }
 *          The base conditions will be T(0)=T(1)=1.
 */
public class CountUniqueBinarySearchTrees {

    private static Map<Integer, Integer> tMap = new HashMap<>();

    public static int numTrees(int n) {
        // base cases
        if (n <= 1) {
            return 1;
        }

        // init vars
        int count = 0;
        // try each value as root
        for (int i = 1; i <= n; i++) {
            if (!tMap.containsKey(i - 1)) {
                tMap.put(i - 1, numTrees(i -1));
            }
            if (!tMap.containsKey(n - i)) {
                tMap.put(n - i, numTrees(n - i));
            }
            count += tMap.get(i - 1) * tMap.get(n - i);
        }

        return count;
    }

}
