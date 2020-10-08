package com.ilya.coding;

import java.util.ArrayList;

/**
 * Input: Linked list with 1 or 0
 * Output: Decimal representation from binary
 * Example: [1, 0, 0] would be 4
 * Option 1: Go over linked list, create array and add numbers
 * to front of array. Then go over array and multiple with power
 * of index.
 * Time: O(N), Space: O(N)
 */
public class DecimalValueFromLinkedList {
    public static int getDecimalValue(ListNode head) {
        // error checking
        if (head == null) {
            return -1;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int decimal = 0;

        // go over linked list and insert to front of array list
        ListNode node = head;
        while (node != null) {
            arr.add(0, node.val);
            node = node.next;
        }

        // multiply by the power of index
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > 0)
                decimal += Math.pow(2, i);
        }

        return decimal;
    }
}
