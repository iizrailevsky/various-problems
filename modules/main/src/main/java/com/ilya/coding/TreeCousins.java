package com.ilya.coding;

/**
 * Cousins in Binary Tree
 * Binay tree. Depth of root == 0, children at k have depth k+1
 * Cousins have same depth but different parents.
 * Root with unique values for nodes with x and y as different nodes in tree.
 * Return true if and only if nodes for x and y are cousins.
 *
 * Input: root TreeNode, int x and int y for values of nodes
 * Output: tree if cousins (at same depth but different parents), false otherwise
 * Constraints: Number of nodes: 2 to 100. Each node has unique value from 1 to 100.
 *
 * Options: Traverse the tree, see if child is x or y, return parent node and its depth.
 *          If parents are different and their depths are same, return true, otherwise
 *          false.
 *          Time: O(N), Space: O(1)
 *
 */
public class TreeCousins {

    public static boolean isCousins(TreeNode root, int x, int y) {
        // error checking
        if (root == null || x < 1 || x > 100 || y < 1 || y > 100 || x == y) {
            return false;
        }

        // traverse and find parent of x and y
        TreeNodeDepth parentX = getParent(root, x, 0);
        TreeNodeDepth parentY = getParent(root, y, 0);

        return (parentX != null && parentY != null && parentX.node != parentY.node
                && parentX.depth == parentY.depth);
    }

    private static TreeNodeDepth getParent(TreeNode node, int val, int level) {
        if (node == null) {
            return null;
        }

        // traverse left
        if (node.left != null) {
            if (node.left.val == val) {
                return new TreeNodeDepth(node, level);
            }

            TreeNodeDepth res = getParent(node.left, val, level + 1);
            if (res != null) {
                return res;
            }
        }

        // traverse right
        if (node.right != null) {
            if (node.right.val == val) {
                return new TreeNodeDepth(node, level);
            }

            TreeNodeDepth res = getParent(node.right, val, level + 1);
            if (res != null) {
                return res;
            }
        }

        return null;
    }

    private static class TreeNodeDepth {
        TreeNode node;
        int depth;
        TreeNodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

}
