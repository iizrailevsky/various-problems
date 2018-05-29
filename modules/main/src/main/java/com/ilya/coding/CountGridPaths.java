package com.ilya.coding;

import java.util.*;

/**
 * You are given a grid of cells with size N rows by M columns.
 * A robot is situated at the bottom-left cell (row N-1, column 0).
 * It can move from cell to cell but only to the right and to the top.
 * Some cells are empty and the robot can pass through them but others are not and the robot cannot enter such cells.
 * The robot cannot go outside the grid boundaries.
 */
public class CountGridPaths {
    public static int countPaths(List<String> grid, boolean useMemoization) {
        // error checking
        if (grid == null || grid.isEmpty()) {
            return -1;
        }

        // init variables
        int[][] intGrid = new int[grid.size()][grid.get(0).length()];

        for (int i = 0; i < grid.size(); i++) {
            char[] charArr = grid.get(i).toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                intGrid[i][j] = Character.getNumericValue(charArr[j]);
            }
        }

        if (useMemoization) { return countPathsWithMemoization(intGrid, grid.size(), grid.get(0).length()); }
        else { return countPathsDP(intGrid, grid.size(), grid.get(0).length()); }
    }

    // with memoization
    private static int countPathsWithMemoization(int[][] grid, int N, int M) {
        // error checking
        if (grid == null || N <= 0 || M <= 0) {
            return -1;
        }

        // init variables
        int[][] pathCount = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                pathCount[i][j] = -1;
            }
        }
        // one way to reach the finish
        pathCount[0][M-1] = 1;

        // recursively compute ways
        countPathsRec(grid, N, M, N - 1, 0, pathCount);

        return pathCount[N-1][0];
    }

    // recursively count path to reach the end
    private static int countPathsRec(int[][] grid, int N, int M, int row, int col, int[][] pathCount) {
        // error checking
        if (row < 0 || row >= N || col < 0 || col >= M || grid[row][col] == 1) {
            return 0;
        }

        // computer path count already?
        if (pathCount[row][col] != -1) {
            return pathCount[row][col];
        }

        // compute pathCount based on varios paths forward
        pathCount[row][col] = countPathsRec(grid, N, M, row - 1, col, pathCount) +
                          countPathsRec(grid, N, M, row, col + 1, pathCount);

        return pathCount[row][col];
    }

    private static int countPathsDP(int[][] grid, int N, int M) {
        // error checking
        if (grid == null || N <= 0 || M <= 0) {
            return -1;
        }

        // init variables
        int[][] pathCount = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                pathCount[i][j] = -1;
            }
        }
        // one way to reach the finish
        pathCount[0][M-1] = 1;

        // go from end to start cell through the matrix grid
        // and compute path counts for each cell
        for (int row = 0; row < N; row++) {
            for (int col = M - 1; col >= 0; col--) {
                // computed path count already?
                if (pathCount[row][col] != -1) {
                    continue;
                }
                // occupied cell?
                if (grid[row][col] == 1) {
                    pathCount[row][col] = 0;
                } else {
                    pathCount[row][col] = ((row - 1 >= 0) ? pathCount[row - 1][col] : 0) +
                                          ((col + 1 < M) ? pathCount[row][col + 1] : 0);
                }
            }
        }


        return pathCount[N-1][0];
    }
}
