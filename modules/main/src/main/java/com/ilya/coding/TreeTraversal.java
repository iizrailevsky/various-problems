package com.ilya.coding;

/*
* Tree traversal
*/


import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TreeTraversal {

	// root node
	private Node root;

	/*
	* Adds nodes to the tree
	*/
	public void add(List<Integer> seq) {
		if (seq == null || seq.size() == 0) {
			System.err.println("No numbers provided!");
		}

		root = new Node(seq.get(0).intValue());
        for (int i = 1; i < seq.size(); i++) {
             add(root, seq.get(i).intValue());
        }
	}

	private void add(Node current, int val) {
		if (current != null) {
			if (val < current.getValue()) {
				if (current.getLeftChild() != null) {
					add(current.getLeftChild(), val);
				} else {
					Node leftNode = new Node(val);
					current.setLeftChild(leftNode);
				}
			} else if (val > current.getValue()) {
				if (current.getRightChild() != null) {
					add(current.getRightChild(), val);
				} else {
					Node rightNode = new Node(val);
					current.setRightChild(rightNode);
				}
			} else {
				// nothing to do - val is equal to current node
			}
		} else {
		}
	}

	public void print() {
		print(root);
	}

    /*
    *   Print out a given list with a message in front
    *
    *   @param root node
    */
    private void print(Node node) {
        // print them out
        if (node != null) {
        	if (node.getLeftChild() != null) {
        		print(node.getLeftChild());
        	}

        	System.out.print(node);

        	if (node.getRightChild() != null) {
        		print(node.getRightChild());
        	}
        }
    }

	// main function
	public static void main(String[] argv) throws Exception {

		List<Integer> seq = new ArrayList<Integer>();

        // read number sequence
        System.out.print("Enter a number sequence: ");
        String numStrs = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        StringTokenizer st = new StringTokenizer(numStrs);
        while (st.hasMoreTokens()) {
            seq.add(new Integer(st.nextToken()));
        }

        TreeTraversal treeTrav = new TreeTraversal();
		treeTrav.add(seq);
		treeTrav.print();

	}

}