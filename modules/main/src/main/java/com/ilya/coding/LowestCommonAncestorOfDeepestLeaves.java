package com.ilya.coding;

/**
 * Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
 *
 * Recall that:
 *
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
 * The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 *
 * Options: Do a post-order traversal. Keep track of depth of the nodes.
 *          If both subtrees contain a deepest leaf, mark this node as the answer so far.
 *          The final node marked will be the correct answer.
 */
public class LowestCommonAncestorOfDeepestLeaves {
    private static int maxDepth;
    private static TreeNode lca;
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        lcaDepth(root, 0);
        return lca;
    }

    private static int lcaDepth(TreeNode node, int depth) {
        // base case - reached leaf?
        if (node == null) {
            return depth;
        }

        // post-order traversal - go left and right first
        int leftDepth = lcaDepth(node.left, depth + 1);
        int rightDepth = lcaDepth(node.right, depth + 1);

        // found deepest lowest common ancsestor?
        if (leftDepth == rightDepth && leftDepth >= maxDepth) {
            maxDepth = leftDepth;
            lca = node;
        }

        return Math.max(leftDepth, rightDepth);
    }

}
