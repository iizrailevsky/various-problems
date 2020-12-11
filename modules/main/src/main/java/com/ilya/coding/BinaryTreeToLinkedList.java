package com.ilya.coding;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * Input: TreeNode - root of tree
 * Output: void - TreeNode updated in place as flattened linked list
 * Constraints: Fit in memory
 * Options: Do pre-order traversal and aggregate the nodes into
 *          an array list. Attach the nodes to each other from the
 *          array list.
 *          Time: O(n) Space: O(2n) = O(n)
 */
public class BinaryTreeToLinkedList {
    public static void flatten(TreeNode root) {
        // error checking
        if (root == null) {
            return;
        }

        List<TreeNode> list = new ArrayList<>();
        // do pre-order travesal
        preorderTraversal(root, list);

        // attach the node into a flattened linked list
        attachNodes(root, list);
    }

    private static void preorderTraversal(TreeNode node, List<TreeNode> list) {
        // base case
        if (node == null) {
            return;
        }

        list.add(node);
        // go left
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }

    private static void attachNodes(TreeNode node, List<TreeNode> list) {
        // error checking
        if (list == null || list.size() <= 1) {
            return;
        }

        // attach the node in sequencial order
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).left = null;
            list.get(i - 1).right = list.get(i);
        }
    }

}
