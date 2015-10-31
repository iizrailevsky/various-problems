package com.ilya.coding;

/*
* Reverse a linked list
* Ilya Izrailevsky
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LinkedListReversal {

    // pointer to linked list first node
    LinkedListNode<String> head;

    public LinkedListReversal(List<String> values) {
        head = null;

        if (values != null && values.size() > 0) {
            head = new LinkedListNode<String>(values.get(0), null);
            LinkedListNode<String> current = head;
            for (int i = 1; i < values.size(); i++) {
                current.setNext(new LinkedListNode<String>(values.get(i), null));
                current = current.next();
            }
        }
    }

    /*
    * Reverses the linked list - recursive
    */
    public void reverse() {
        head = reverse(head, null);
    }

    private LinkedListNode<String> reverse(LinkedListNode<String> current, LinkedListNode<String> previous) {
        if (current == null) {
            return null;
        }

        if (current.next() == null) {
            current.setNext(previous);
            return current;
        } else {
            LinkedListNode<String> temp = reverse(current.next(), current);
            current.setNext(previous);
            return temp;
        }
    }

    /*
    * Reverses the linked list - non-recursive
    */
    public void reverseNonRec() {
        head = reverse(head);
    }

    private LinkedListNode<String> reverse(LinkedListNode<String> current) {
        LinkedListNode<String> temp;
        LinkedListNode<String> previous = null;

        while (current != null) {
            temp = current.next();
            current.setNext(previous);
            previous = current;
            current = temp;
        }
        return previous;
    }

    public void dumpLinkedList() {
        if (head != null) {
            LinkedListNode<String> current = head;
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

        LinkedListReversal reversal = new LinkedListReversal(seq);
        reversal.reverseNonRec();
        reversal.dumpLinkedList();
    }

}