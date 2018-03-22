package com.ilya.coding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TreePrintLeft {

    public static void main(String[] args) {

        System.out.println("Iterative: " + getNodeValuesFromLeft(null));
        System.out.println("Recursive: " + getNodeValuesFromLeftRecursive(null));

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        System.out.println("Iterative: " + getNodeValuesFromLeft(one));
        System.out.println("Recursive: " + getNodeValuesFromLeftRecursive(one));

        one.setLeftChild(two);
        one.setRightChild(three);
        two.setRightChild(five);
        three.setRightChild(four);

        System.out.println("Iterative: " + getNodeValuesFromLeft(one));
        System.out.println("Recursive: " + getNodeValuesFromLeftRecursive(one));

        Node seven = new Node(7);
        Node nine = new Node(9);
        Node ten = new Node(10);

        four.setLeftChild(seven);
        seven.setLeftChild(nine);
        seven.setRightChild(ten);

        System.out.println("Iterative: " + getNodeValuesFromLeft(one));
        System.out.println("Recursive: " + getNodeValuesFromLeftRecursive(one));
    }

    // returns a list of node values visible from left side
    public static List<Integer> getNodeValuesFromLeft(Node root) {
        // error checking
        if (root == null) {
            return new ArrayList<>(1);
        }

        // init variables
        Map<Integer, Integer> levelToLeftVal = new HashMap<>();
        List<Node> qNodes = new ArrayList<>();
        List<Integer> qLevels = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        // start with root and traverse pre-order
        qNodes.add(root);
        qLevels.add(0);
        for (int i = 0; i < qNodes.size(); i++) {
            Node curNode = qNodes.get(i);
            int curLevel = qLevels.get(i);
            // found left node?
            if (!levelToLeftVal.containsKey(curLevel)) {
                levelToLeftVal.put(curLevel, curNode.getValue());
            }

            // go left if possible
            if (curNode.getLeftChild() != null) {
                qNodes.add(curNode.getLeftChild());
                qLevels.add(curLevel + 1);
            }

            // go right if possible
            if (curNode.getRightChild() != null) {
                qNodes.add(curNode.getRightChild());
                qLevels.add(curLevel + 1);
            }
        }

        // populate result list
        for (int j = 0; j < levelToLeftVal.size(); j++) {
            if (levelToLeftVal.containsKey(j)) {
                res.add(levelToLeftVal.get(j));
            }
        }

        return res;
    }

    // returns a list of node values visible from left side
    public static List<Integer> getNodeValuesFromLeftRecursive(Node root) {
        // error checking
        if (root == null) {
            return new ArrayList<>(1);
        }

        // init variables
        Map<Integer, Integer> levelToLeftVal = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        // recursively populate level to left val map
        getNodeValuesFromLeftRec(root, 0, levelToLeftVal);

        // populate result list
        for (int j = 0; j < levelToLeftVal.size(); j++) {
            if (levelToLeftVal.containsKey(j)) {
                res.add(levelToLeftVal.get(j));
            }
        }

        return res;
    }

    private static void getNodeValuesFromLeftRec(Node curNode, int curLevel, Map<Integer, Integer> levelToLeftVal) {
        // error checking
        if (curNode == null) {
            return;
        }

        // found left node?
        if (!levelToLeftVal.containsKey(curLevel)) {
            levelToLeftVal.put(curLevel, curNode.getValue());
        }

        // go left if possible
        if (curNode.getLeftChild() != null) {
            getNodeValuesFromLeftRec(curNode.getLeftChild(), curLevel + 1, levelToLeftVal);
        }

        // go right if possible
        if (curNode.getRightChild() != null) {
            getNodeValuesFromLeftRec(curNode.getRightChild(), curLevel + 1, levelToLeftVal);
        }

    }

}

