package com.ilya.coding;

import java.util.*;

public class TreePrintLevelOrder {

    // returns list of elements in tree in zigzag / level order
    public static List<Integer> getTreeZigZagOrder(Node node) {
        // error checking
        if (node == null) {
            return Collections.EMPTY_LIST;
        }

        // init vars
        List<Node> q = new ArrayList();
        List<Integer> res = new ArrayList();

        // add root node to q
        q.add(node);

        // go over tree in breadth 1st order
        for (int i = 0; i < q.size(); i++) {
            Node cur = q.get(i);
            // add current node to result list
            res.add(cur.getValue());

            // go left if possible
            if (cur.getLeftChild() != null) {
                q.add(cur.getLeftChild());
            }
            // go right if possible
            if (cur.getRightChild() != null) {
                q.add(cur.getRightChild());
            }

        }

        return res;
    }
}
