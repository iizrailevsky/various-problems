package com.ilya.coding;

import java.util.*;


public class LevelSum {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static int getLevelSum(Node root, int N) {
        /*
          Please implement this method to
          traverse the tree and return the sum of the values (Node.getValue()) of all nodes
          at the level N in the tree.
          Node root is assumed to be at the level 1. All its children are level 2, etc.
         */
         // check for null root
         if (root == null) {
         	return -1;
         }

         // base case - return value of root
         if (N == 1) {
         	return root.getValue();
         } else {
         	int sum = 0;
         	for (Node child : root.getChildren()) {
         		int val = getLevelSum(child, N - 1);
         		if (val > 0) {
         			sum += val;
         		}
         	}
         	return sum;
        }
    }
}
