package com.ilya.coding;

import java.util.*;


public class TraverseTreeInDepth {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static List<Node> traverseTreeInDepth(Node root) {
        /*
          Please implement this method to
          traverse the tree in depth and return a list of all passed nodes.

          The method shall work optimally with large trees.
         */

        if (root == null) {
        	return Collections.EMPTY_LIST;
        }
        List<Node> result = new ArrayList<Node>();
        traverseTreeInDepth(root, result);
        return result;
    }

    public static void traverseTreeInDepth(Node root, List<Node> result) {
        result.add(root);
        for (Node child : root.getChildren())
        	traverseTreeInDepth(root, result);
    }
}
