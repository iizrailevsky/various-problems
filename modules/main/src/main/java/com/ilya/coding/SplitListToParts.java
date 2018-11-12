package com.ilya.coding;

public class SplitListToParts {

    public static ListNode[] splitListToParts(ListNode root, int k) {
        if (k <= 0) {
            return null;
        }

        ListNode[] res = new ListNode[k];
        if (root == null) {
            return res;
        }

        // calculate num of elements
        int n = 0;
        for (ListNode i = root; i != null; i = i.next) {
            n++;
        }

        if (n / k == 0) {
            splitIntoOneElemParts(n, k, root, res);
        } else {
            splitIntoMultiElemParts(n, k, root, res);
        }

        return res;
    }

    // split into k 1-element list parts until root expires
    private static void splitIntoOneElemParts(int n, int k, ListNode root, ListNode[] res) {
        int j = 0;
        for (ListNode i = root; i != null; i = i.next) {
            res[j] = new ListNode(i.val);
            j++;
        }
    }

    // split into k list parts, with n/k elements in each
    // plus 1 more element added to n%k 1st parts
    private static void splitIntoMultiElemParts(int n, int k, ListNode root, ListNode[] res) {
        int j = 0;
        int p = 0;
        ListNode partNode = null;
        int partLen = n / k;
        int addLen = n % k;

        for (ListNode i = root; i != null; i = i.next) {
            if (p == 0) {
                // starting 1st part
                res[j] = new ListNode(i.val);
                partNode = res[j];
                p++;
            } else if (p < partLen + ((j < addLen) ? 1 : 0)) {
                // still populating part
                partNode.next = new ListNode(i.val);
                partNode = partNode.next;
                p++;
            } else {
                // reached end of part - start a new one
                j++;
                res[j] = new ListNode(i.val);
                partNode = res[j];
                p = 1;
            }
        }
    }
}
