package com.ilya.coding;

public class MinimumPathSum {

    // return minimum path sum from top-left to bottom-right
    public static int minPathSum(int[][] grid) {
        // error checking
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        // go over matrix and calculate minimum running path sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    // skip 1st cell
                    continue;
                }

                int cur = grid[i][j];
                int minCellFrom = Integer.MAX_VALUE;
                if (i > 0) {
                    // select from left path if possible
                    minCellFrom = Math.min(minCellFrom, grid[i - 1][j]);
                }
                if (j > 0) {
                    // select from right path if possible
                    minCellFrom = Math.min(minCellFrom, grid[i][j - 1]);
                }
                grid[i][j] = minCellFrom + cur;
            }
        }

        return grid[n - 1][m - 1];
    }
}
