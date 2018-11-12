package com.ilya.coding;

import java.util.*;

public class LinkedListComponents {

    public static int numComponents(ListNode head, int[] G) {
        // error checking
        if (head == null || G == null || G.length == 0) {
            return 0;
        }

        Set<Integer> gSet = getGSet(G);
        int numComps = numComponentsRec(head, gSet, false, 0);
        return numComps;
    }

    private static Set<Integer> getGSet(int[] G) {
        Set<Integer> res = new HashSet();
        for (int i : G) {
            res.add(i);
        }
        return res;
    }

    private static int numComponentsRec(ListNode node, Set<Integer> gSet, boolean compStarted, int numComps) {
        if (node == null) {
            return (compStarted) ? numComps + 1 : numComps;
        }

        if (gSet.contains(node.val)) {
            return numComponentsRec(node.next, gSet, true, numComps);
        } else{
            return numComponentsRec(node.next, gSet, false, (compStarted) ? numComps + 1 : numComps);
        }
    }
}
