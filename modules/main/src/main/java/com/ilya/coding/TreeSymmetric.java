package com.ilya.coding;

import java.util.*;

public class TreeSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> leftNodes = new ArrayList();
        List<Integer> rightNodes = new ArrayList();

        traverseNodes(root.left, true, leftNodes);
        traverseNodes(root.right, false, rightNodes);

        return listsMatch(leftNodes, rightNodes);
    }

    private static void traverseNodes(TreeNode node, boolean isLeftFirst, List<Integer> nodes) {
        if (node == null) {
            nodes.add(-1);
            return;
        }

        nodes.add(node.val);

        if (isLeftFirst) {
            traverseNodes(node.left, isLeftFirst, nodes);
            traverseNodes(node.right, isLeftFirst, nodes);
        } else {
            traverseNodes(node.right, isLeftFirst, nodes);
            traverseNodes(node.left, isLeftFirst, nodes);
        }
    }

    private static boolean listsMatch(List<Integer> leftNodes, List<Integer> rightNodes) {
        if (leftNodes == null && rightNodes == null || leftNodes.isEmpty() && rightNodes.isEmpty()) {
            return true;
        }
        if (leftNodes.size() != rightNodes.size()) {
            return false;
        }

        int i = 0;
        int j = 0;
        int n = leftNodes.size();

        while (i < n && j < n) {
            if (leftNodes.get(i) != rightNodes.get(j)) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}
