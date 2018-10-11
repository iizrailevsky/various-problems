package com.ilya.coding;

import java.util.*;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        // error checking
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }

        int n = triangle.size();

        for (int row = 1; row < n; row++) {
            int prevM = triangle.get(row - 1).size();
            int m = triangle.get(row).size();
            List<Integer> prevRowList = triangle.get(row - 1);
            List<Integer> rowList = triangle.get(row);

            // set 1st col
            rowList.set(0, rowList.get(0) + prevRowList.get(0));
            // set cols in between
            for (int col = 1; col < m - 1; col++) {
                rowList.set(col, rowList.get(col) + Math.min(prevRowList.get(col - 1), prevRowList.get(col)));
            }
            // set last col
            rowList.set(m - 1, rowList.get(m - 1) + prevRowList.get(prevM - 1));
        }

        // find min total in last row
        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            minTotal = Math.min(minTotal, triangle.get(n - 1).get(i));
        }

        return minTotal;
    }
}
