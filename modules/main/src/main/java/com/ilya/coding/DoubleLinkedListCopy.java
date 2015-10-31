package com.ilya.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* Double Linked List Node
* Ilya Izrailevsky
*/
public class DoubleLinkedListCopy {

    // pointer to linked list first node
    DLLNode head;

    public DoubleLinkedListCopy(List<String> values) {
        head = null;

        if (values != null && values.size() > 0) {
            head = new DLLNode(values.get(0), null);
            DLLNode current = head;
            for (int i = 1; i < values.size(); i++) {
                current.setNext(new DLLNode(values.get(i), null));
                current = current.next();
            }
        }
    }

    public DLLNode copy()
	{
	    DLLNode current = head;
	    DLLNode temp;
	    DLLNode next;

	    // create a copy of the original list
	    // make original list's node point to the copied
	    while (current != null) {
	    	temp = new DLLNode(current.getValue());
	    	temp.setNext(current.next());
	    	next = current.next();
	    	current.setNext(temp);
	    	current = next;
	    }

	    // head of copy pointer
	    DLLNode copyHead = head.next();

	    // now copy the back link from original
	    current = head;
	    while (current != null) {
	    	current.next().setBack(current.back().next());
	    	current = current.next().next();
	    }

	    // now put back the original pointers
	    current = head;
	    temp = head.next();
	    while (current != null && temp != null) {
	    	current.setNext(current.next().next());
	    	current = current.next();
	    	if (temp.next() != null) {
	    		temp.setNext(temp.next().next());
	    		temp = temp.next();
	    	}
	    }

	    return copyHead;
	}


    public static void dumpLinkedList(DLLNode head) {
        if (head != null) {
            DLLNode current = head;
            System.out.print("List: " + current);
            while (current.next() != null) {
                System.out.print(current.next());
                current = current.next();
            }
        }
    }

    public static void main(String[] argv) throws Exception {

        List<String> seq = new ArrayList<String>();

        // read number sequence
        System.out.print("Enter a sequence: ");
        String numStrs = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        StringTokenizer st = new StringTokenizer(numStrs);
        while (st.hasMoreTokens()) {
            seq.add(st.nextToken());
        }

        DoubleLinkedListCopy copier = new DoubleLinkedListCopy(seq);
        DLLNode copy = copier.copy();
        dumpLinkedList(copy);
    }
}