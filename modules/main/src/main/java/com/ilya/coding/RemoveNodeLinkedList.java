package com.ilya.coding;

/**
 * Created by iizrailevsky on 4/6/18.
 */
public class RemoveNodeLinkedList {

    public static void main(String[] args) {

        // 1st test case
        LinkedListNode<Integer> ret1 = removeNodesWithValue(null, 1);


    }

    /**
     * Removes nodes with a given values from linked list
     * and returns the head of the linked list
     * @param root Root of linked list
     * @param value Value of the nodes to be removed
     * @return Root of linked list
     */
    public static LinkedListNode<Integer> removeNodesWithValue(LinkedListNode<Integer> root, int value) {
        // error checking
        if (root == null) {
            return null;
        }

        // check root node and immediate nodes
        while (root.getValue() == value) {
            if (root.next() == null) {
                return null;
            }
            root = root.next();
        }

        // recursively traverse the linked list and remove the nodes matching the value
        removeNodesWithValueRec(root, root.next(), value);

        return root;
    }

    private static void removeNodesWithValueRec(LinkedListNode<Integer> prev, LinkedListNode<Integer> cur, int value) {
        // error checking
        if (cur == null) {
            return;
        }

        // found node to be removed?
        if (cur.getValue() == value) {
            prev.setNext(cur.next());
            removeNodesWithValueRec(prev, cur.next(), value);
        } else {
            removeNodesWithValueRec(cur, cur.next(), value);
        }
    }
}
