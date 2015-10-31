package com.ilya.coding;

/*
* Node object
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Node {

	// value
	private int value;
	// chindren nodes
	private Node leftNode;
	private Node rightNode;

	public Node(int value) {
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return this.leftNode;
	}

	public void setLeftChild(Node child) {
		this.leftNode = child;
	}

	public Node getRightChild() {
		return this.rightNode;
	}

	public void setRightChild(Node child) {
		this.rightNode = child;
	}

	public String toString() {
		return new String(" " + this.getValue() + " ");
	}

}