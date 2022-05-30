package com.ilya.coding;

/**
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * A subtree of a node node is node plus every node that is a descendant of node.
 *
 * Input: root Root of tree with 0's or 1's as values.
 * Output: root Same tree where every subtree not containing a 1 has been removed.
 * Constraints: The number of nodes in the tree is in the range [1, 200]
 *              Node.val is either 0 or 1
 * Examples:
 *  A. Input: root = [1,null,0,0,1]
 *     Output: [1,null,0,null,1]
 *  B. Input: root = [1,0,1,0,0,0,1]
 *     Output: [1,null,1,null,1]
 *  C: Input: root = [1,1,0,1,1,0,1,0]
 *     Output: [1,1,0,1,1,null,1]
 *
 *  Options: Go over the tree in post-order traversal to check if the descendant
 *           nodes contain at least one (left or right) leaf node or subtree with 1's.
 *           Remove leaf nodes with 0 or subtrees that had only 0's.
 */
public class PruneZeroSubtrees {
    public static TreeNode pruneTree(TreeNode root) {
        // error checking
        if (root == null) {
            return null;
        }

        // traverse in post-order and prune nodes or subtree's with 0's only
        boolean isRootZeroSubtree = isZeroSubtreeAndPrune(root);

        // return empty root if it's subtree is zero
        return isRootZeroSubtree ? null : root;
    }

    private static boolean isZeroSubtreeAndPrune(TreeNode node) {
        // base case
        if (node == null) {
            return true;
        }

        // traverse post-order
        boolean isLeftZeroSubtree = isZeroSubtreeAndPrune(node.left);
        boolean isRightZeroSubtree = isZeroSubtreeAndPrune(node.right);

        // left zero subtree? prune
        if (isLeftZeroSubtree) {
            node.left = null;
        }
        // right zero subtree? prune
        if (isRightZeroSubtree) {
            node.right = null;
        }
        // both left and right zero subtrees and current node is 0?
        // to be pruned by parent
        if (node.val == 0 && isLeftZeroSubtree && isRightZeroSubtree) {
            return true;
        }

        return false;
    }
}
