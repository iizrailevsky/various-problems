package com.ilya.coding;

import java.util.*;
import java.util.Stack;

public class TreePrintZigZagOrder {

    // returns list of elements in tree in zigzag order
    // left to right, then right to left, left to right, right to left...
    public static List<Integer> getTreeZigZagOrder(Node node) {
        // error checking
        if (node == null) {
            return Collections.EMPTY_LIST;
        }

        Stack<Node> currentLevelSt = new Stack();
        Stack<Node> nextLevelSt = new Stack();
        boolean leftToRight = true;
        List<Integer> res = new ArrayList();

        // push root to current level stack
        currentLevelSt.push(node);

        while (!currentLevelSt.isEmpty()) {
            Node cur = currentLevelSt.pop();
            res.add(cur.getValue());

            if (leftToRight) {
                // push in left to right order as next level will
                // pop in reverse (right to left) order
                if (cur.getLeftChild() != null) {
                    nextLevelSt.push(cur.getLeftChild());
                }
                if (cur.getRightChild() != null) {
                    nextLevelSt.push(cur.getRightChild());
                }
            } else {
                if (cur.getRightChild() != null) {
                    nextLevelSt.push(cur.getRightChild());
                }
                if (cur.getLeftChild() != null) {
                    nextLevelSt.push(cur.getLeftChild());
                }
            }

            // current level done?
            if (currentLevelSt.isEmpty()) {
                // move to current to next and
                // next back to current stack
                Stack<Node> temp = currentLevelSt;
                currentLevelSt = nextLevelSt;
                nextLevelSt = temp;
                // flip to opposite to order
                leftToRight = !leftToRight;
            }
        }

        return res;
    }
}
