package com.ilya.coding;

import java.util.*;

public class ChooseKFromN {

    // choose k unique combinations from n elements
    public static List<List<Integer>> chooseKFromN(int[] a, int k) {
        // error checking
        if (a == null || a.length == 0 || k <= 0) {
            return null;
        }

        // init variables
        // temp array to store combinations
        int n = a.length;
        int[] data = new int[n];
        List<List<Integer>> result = new ArrayList<>();

        // recursively add to result
        chooseKFromNRec(a, data, n, k, 0, 0, result);

        return result;
    }

    private static void chooseKFromNRec(int[] a, int[] data, int n, int k, int index, int i, List<List<Integer>> result) {
        // reached k elements - add to the result set
        if (index == k) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                list.add(data[j]);
            }
            result.add(list);
            return;
        }

        // out of elements in array?
        if (i >= n) {
            return;
        }

        // current element is included, put next at next location
        data[index] = a[i];
        chooseKFromNRec(a, data, n, k, index + 1, i + 1, result);

        // current element is excluded, override it with next
        chooseKFromNRec(a, data, n, k, index, i + 1, result);

    }
}
