package com.ilya.coding;

import java.util.*;

public class SerializeTree {

    // serializes tree of positive integers into an array
    public static int[] serializeTree(Node root) {
        // error checking
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        serializeTreeRec(root, result);
        int[] array = result.stream().mapToInt(i->i).toArray();
        return array;
    }

    private static void serializeTreeRec(Node node, List<Integer> result) {
        // error checking
        if (node == null) {
            result.add(-1); // sentinel as -1
            return;
        }

        // add current node to array
        result.add(node.getValue());
        // go left
        serializeTreeRec(node.getLeftChild(), result);
        serializeTreeRec(node.getRightChild(), result);
    }

    // deserialize array to tree
    public static Node deserializeTree(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        Node root = null;
        // reset index
        index = 0;
        root = deserializeTreeRec(root, a);
        return root;
    }

    private static int index = 0;

    private static Node deserializeTreeRec(Node node, int[] a) {
        if (index >= a.length) {
            return null;
        }
        // sentinel as -1
        if (a[index] == -1) {
            index++;
            return null;
        }

        node = new Node(a[index]);
        // go to next index
        index++;
        node.setLeftChild(deserializeTreeRec(node.getLeftChild(), a));
        node.setRightChild(deserializeTreeRec(node.getRightChild(), a));

        return node;
    }
}
