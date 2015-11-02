package com.ilya.coding;


public class LinkedListNode<T> {

    public LinkedListNode(T value, LinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    // node value
    private T value;

    // next node
    private LinkedListNode<T> next;

    // contructor with value param
    public LinkedListNode(T value) {
        this.value = value;
        this.next = null;
    }

    // get node value
    public T getValue() {
        return this.value;
    }

    // get next node
    public LinkedListNode<T> next() {
        return this.next;
    }

    // set next node
    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

}
