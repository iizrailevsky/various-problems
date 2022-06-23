package com.ilya.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * - Rank is an integer starting from 1.
 * - The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * - Rank should be as small as possible.
 *
 * Input: int[] arr of numbers
 * Output: array of ranks of the number elements
 * Options: Add elements to a sorted set. Iterate over the sorted set and to a HashMap<Int(element), Int(rank)>.
 *          Go over the arr, lookup element and its rank in the HashMap and add to the output.
 */
public class ArrayRankTransform {
    public static int[] arrayRankTransform(int[] arr) {
        // error checking
        if (arr == null || arr.length == 0) {
            return arr;
        }

        // init vars
        int n = arr.length;
        int[] ranks = new int[n];

        // create a sorted set with the elements
        Set<Integer> sortedSet = new TreeSet<>();
        for (int el: arr) {
            sortedSet.add(el);
        }

        // create mapping of element to rank
        Map<Integer, Integer> elemToRankMap = new HashMap<>();
        int rank = 1;
        for (int el: sortedSet) {
            elemToRankMap.put(el, rank);
            rank++;
        }

        // go over the arr and populate the ranks output array
        for (int i = 0; i < n; i++) {
            ranks[i] = elemToRankMap.get(arr[i]);
        }

        return ranks;
    }
}
