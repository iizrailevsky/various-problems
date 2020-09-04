package com.ilya.coding;

import java.util.*;

/**
 * Given 2 lists of integers, returns their intersection and union.
 * Input: 2 sorted lists of ints
 * Output: 3rd list of ints with their intersection and union
 * Example: a: [-7, -3, 0, 1, 5, 10, 17]
 *          b: [-15, -10, -3, 1, 2, 10]
 *          o: [-3, 1, 10]
 * Options:
 *          Go over a and b, if equal, then add to o, if a[i] < b[j], i++, else j++
 */
public class ListIntersectionUnion {

    /**
     * Returns intersection between a and b
     * @param a List of integers
     * @param b List of integers
     * @return o List with intersection of elements
     */
    public static List<Integer> getIntersection(List<Integer> a, List<Integer> b) {
        // error checking
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return new ArrayList<>();
        }

        // init vars
        int i = 0, j = 0;
        List<Integer> o = new ArrayList<>();

        // go over a and b and find intersection
        while (i < a.size() && j < b.size()) {
            if (a.get(i) == b.get(j)) {
                o.add(a.get(i));
                i++;
                j++;
            } else if (a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return o;
    }

    /**
     * Returns union between a and b
     * @param a List of integers
     * @param b List of integers
     * @return o List with union of elements
     */
    public static List<Integer> getUnion(List<Integer> a, List<Integer> b) {
        // error checking
        if (a == null || a.isEmpty()) {
            if (b != null) {
                return b;
            } else {
                return new ArrayList<>();
            }
        } else if (b == null || b.isEmpty()) {
            if (a != null) {
                return a;
            } else {
                return new ArrayList<>();
            }
        }

        // init vars
        int i = 0, j = 0;
        List<Integer> o = new ArrayList<>();

        // go over a and b and find union
        while (i < a.size() && j < b.size()) {
            if (a.get(i) == b.get(j)) {
                o.add(a.get(i));
                i++;
                j++;
            } else if (a.get(i) < b.get(j)) {
                o.add(a.get(i));
                i++;
            } else {
                o.add(b.get(j));
                j++;
            }
        }

        if (i < a.size()) {
            while (i < a.size()) {
                o.add(a.get(i));
                i++;
            }
        }

        if (j < b.size()) {
            while (j < b.size()) {
                o.add(b.get(j));
            }
        }

        return o;
    }

}
