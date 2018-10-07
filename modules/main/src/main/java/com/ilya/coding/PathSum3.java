package com.ilya.coding;

public class PathSum3 {
    public static int pathSum(TreeNode root, int sum) {
        // error checking
        if (root == null) {
            return 0;
        }

        int pathSum = pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return pathSum;
    }

    private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int pathSum = 0;

        // path ended here?
        if (node.val == sum) {
            pathSum++;
        }

        // try with using current value
        pathSum += pathSumFrom(node.left, sum - node.val);
        pathSum += pathSumFrom(node.right, sum - node.val);

        return pathSum;
    }

}
