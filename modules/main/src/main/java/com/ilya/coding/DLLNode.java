package com.ilya.coding;

/*
* Double Linked List Node
* Ilya Izrailevsky
*/
public class DLLNode {

    // node data
    private String value;

    // link to next node
    private DLLNode next;

    // link to back or random node
    private DLLNode back;

    public DLLNode(String value, DLLNode next) {
        this.value = value;
        this.next = next;
        this.back = null;
    }

    public DLLNode(String value) {
    	this.value = value;
    	this.next = null;
    	this.back = null;
    }

    public String getValue() {
        return this.value;
    }

    public DLLNode next() {
        return this.next;
    }

    public void setNext(DLLNode newNext) {
        this.next = newNext;
    }

    public String toString() {
        return this.getValue() + " ";
    }

    public DLLNode back() {
    	return this.back;
    }

    public void setBack(DLLNode back) {
    	this.back = back;
    }
}