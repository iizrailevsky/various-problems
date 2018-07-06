package com.ilya.coding;

import java.util.*;

public class ArithmeticSlices {

    public static int numberOfArithmeticSlices(int[] a) {
        // error checking
        if (a == null || a.length == 0) {
            return 0;
        }

        // init vars
        int n = a.length;
        int[] data = new int[n];
        Set<String> resultSet = new HashSet<>();

        numberOfArithmeticSlicesRec(a, data, 0, 0, n, resultSet);

        return resultSet.size();
    }

    private static void numberOfArithmeticSlicesRec(int[] a, int[] data, int i, int index, int n, Set<String> resultSet) {
        // arithmetic slice?
        if (index >= 3) {
            String res = Arrays.toString(Arrays.copyOfRange(data, 0, index));
            if (!resultSet.contains(res)) {
                System.out.println(res);
                resultSet.add(res);
            }
        }
        // error checking
        if (i >= n) {
            return;
        }

        // include current element? if 1st two elements or difference is equal
        if (index == 0 || index == 1 || a[i] - data[index - 1] == data[index - 1] - data[index - 2]) {
            data[index] = a[i];
            numberOfArithmeticSlicesRec(a, data, i + 1, index + 1, n, resultSet);
        }
        // exclude current element, override it with next
        numberOfArithmeticSlicesRec(a, data, i + 1, index, n, resultSet);
    }
}
