package com.ilya.coding;

import java.util.*;


public class LinkedListFindMax {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        Node next();
        void setNext(Node node);
    }


    public static int findMax(Node node) {
    	// error checking
    	if (node == null) {
    		return -1;
    	}

    	return Math.max(node.getValue(), findMax(node.next()));
    }


}
