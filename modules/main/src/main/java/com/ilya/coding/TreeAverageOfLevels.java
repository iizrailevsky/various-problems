package com.ilya.coding;

import java.util.*;

public class TreeAverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        // error checking
        if (root == null) {
            return null;
        }

        Map<Integer, List<Integer>> levelToValues = new HashMap<>();
        collectLevelToValues(root, 0, levelToValues);
        return calculateAverages(levelToValues);
    }

    private static void collectLevelToValues(TreeNode root, int level, Map<Integer, List<Integer>> levelToValues) {
        if (root == null) {
            return;
        }

        if (levelToValues.containsKey(level)) {
            List<Integer> values = levelToValues.get(level);
            values.add(root.val);
        } else {
            List<Integer> values = new ArrayList<>();
            values.add(root.val);
            levelToValues.put(level, values);
        }

        // go left
        collectLevelToValues(root.left, level + 1, levelToValues);
        // go right
        collectLevelToValues(root.right, level + 1, levelToValues);
    }

    private static List<Double> calculateAverages(Map<Integer, List<Integer>> levelToValues) {
        int numLevels = levelToValues.entrySet().size();
        List<Double> resultList = new ArrayList<>(numLevels);

        for (int i = 0; i < numLevels; i++) {
            List<Integer> values = levelToValues.get(i);
            double sum = 0;
            for (int v : values) {
                sum += v;
            }
            resultList.add(sum / values.size());
        }
        return resultList;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
