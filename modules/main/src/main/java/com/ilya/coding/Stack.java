package com.ilya.coding;

// Stack class
public class Stack {
	// linked list head
	private Node head;

	// default constructor
	public Stack() {
		this.head = null;
	}

	// Push a new item onto the stack
	// @param int New value
	public void push(int value) {
		// create a new linked list node
		Node newNode = new Node(value);

		// update the head
		// 1 - if the head is null - set the head to new node
		if (this.head == null) {
			this.head = newNode;
		}
		// 2 - if the head exists - make next of new node point to head,
		// make head point to new node
		else {
			newNode.setNext(this.head);
			this.head = newNode;
		}
	}

	// Pop the head of the stack
	// @return value of the stack's top if exists, -1 otherwise
	public int pop() {
		// 1 - if the head is null - return -1
		if (this.head == null) {
			return -1;
		}

		// 2 - if the head exists - get the head's next pointer node
		// record the value of current head
		// make head point to the next pointer node
		// return the value of current head
		Node newHead = this.head.next();
		Node currentHead = this.head;
		int result = this.head.getValue();
		this.head = newHead;
		currentHead.setNext(null);
		currentHead = null;
		return result;
	}

	// Linked list node
	public class Node {
	    // node value
	    private int value;

	    // next node
	    private Node next;

	    // contructor with value param
	    public Node(int value) {
	        this.value = value;
	        this.next = null;
	    }

	    // get node value
	    public int getValue() {
	        return this.value;
	    }

	    // get next node
	    public Node next() {
	        return this.next;
	    }

	    // set next node
	    public void setNext(Node next) {
	        this.next = next;
	    }
	}
}
