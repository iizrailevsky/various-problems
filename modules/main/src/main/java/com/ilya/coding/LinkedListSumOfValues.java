package com.ilya.coding;

/**
 * Returns sum of values in a given linked list.
 * Input: node: ListNode
 * Output: sumOfValues: int
 * Constraints: non-empty linked list
 * Options: Recursively sum current value with the rest of sum.
 * Time: O(n), Space: O(n)
 */
public class LinkedListSumOfValues {
    public static int sumOfValuesRec(ListNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + sumOfValuesRec(node.next);
    }
}
