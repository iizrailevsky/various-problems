package com.ilya.coding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a Binary Search Tree (BST) let us convert it to a Binary Tree with one particular condition:
 *     New value of a node = Sum(All nodes in the BST >= current node value)
 *
 *
 *            5
 *     3             7
 * 2       4    6         8
 *
 *         ||
 *         v
 *
 *               26
 *     33                  15
 * 35          30      21         8
 *
 * Input: BST, given root TreeNode
 * Output: Binary tree where each node has new value = Sum(All nodes in the BST >= current node value)
 * Constraints: Memory bound within one machine
 * Example:
 *       5     =>    18
 *    3    7      25       7
 *      4 6         22  13
 * Options: Bruce force: For each node, go over all other nodes,
 *          find >= nodes, add them up + current node.
 *          Time: O(N*N), Space: O(N)
 *          Optimization: Create [3, 4, 5, 6, 7] => running sum from right to left [25, 22, 18, 13, 7]
 *          Time: O(N), Space: O(N)
 */
public class BSTtoBTConverter {

    public static TreeNode convertBSTtoBT(TreeNode root) {
        // error checking
        if (root == null) {
            return null;
        }

        // traverse tree and populate into array
        ArrayList<Integer> arr = new ArrayList<>();
        populateArrayFromBST(root, arr);

        System.out.println("Initial BST array: " + Arrays.toString(arr.toArray()));

        // generate running sum array
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (i != arr.size() - 1) {
                arr.set(i, arr.get(i) + arr.get(i + 1));
            }
        }

        System.out.println("Running sum BST array: " + Arrays.toString(arr.toArray()));

        // populate BT in place with the running sum values
        updateTreeWithSumValue(root, arr);

        return root;
    }

    /**
     * Traverse in order and populate array from BST
     * @param node
     * @param arr
     */
    private static void populateArrayFromBST(TreeNode node, ArrayList<Integer> arr) {
        // base case
        if (node == null) {
            return;
        }

        populateArrayFromBST(node.left, arr);
        arr.add(node.val);
        populateArrayFromBST(node.right, arr);
    }

    /**
     * Populate BT in place with the running sum values
     * @param node
     * @param arr
     */
    private static void updateTreeWithSumValue(TreeNode node, ArrayList<Integer> arr) {
        // base case
        if (node == null || arr.isEmpty()) {
            return;
        }

        updateTreeWithSumValue(node.left, arr);
        node.val = arr.remove(0);
        updateTreeWithSumValue(node.right, arr);
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(7, new TreeNode(6), new TreeNode(8))
        );

        TreeNode res = convertBSTtoBT(node);
        ArrayList<Integer> out = new ArrayList<>();
        populateArrayFromBST(res, out);
        System.out.println("Result sum binary tree: " + Arrays.toString(out.toArray()));
    }
}
