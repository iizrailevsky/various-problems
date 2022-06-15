package com.ilya.coding;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * Input: root - TreeNode, root of the binary search tree, k - target sum of two elements in the tree
 * Output: true if there're two elements that sum up to target k, false otherwise
 * Constraints: The number of nodes in the tree is in the range [1, 10^4]
 *              -10^4 <= Node.val <= 10^4
 *              root is guaranteed to be a valid binary search tree
 *              -10^5 <= k <= 10^5
 * Options: Traverse the BST from root, add elements to a Set<Integer>.
 *          While traversing, check for every element e,
 *          there's another element a where (k - e) = a. If so return true.
 *          Time: O(n), Space: O(n)
 *
 */
public class TreeFindSumTarget {
    public static boolean findTarget(TreeNode root, int k) {
        // error checking
        if (root == null) {
            return false;
        }

        // init vars
        Set<Integer> elems = new HashSet<>();

        return traverseAndCheckSet(root, elems, k);
    }

    private static boolean traverseAndCheckSet(TreeNode node, Set<Integer> elems, int k) {
        // base case
        if (node == null) {
            return false;
        }

        // is there another element a where (k - e) = a and it's not the same element
        if (elems.contains(k - node.val)) {
            return true;
        }
        // add current elements to the elems set
        elems.add(node.val);

        // go left && right
        return traverseAndCheckSet(node.left, elems, k) || traverseAndCheckSet(node.right, elems, k);
    }
}
