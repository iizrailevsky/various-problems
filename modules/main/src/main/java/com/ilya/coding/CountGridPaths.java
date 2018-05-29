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
    public static int countPaths(List<String> grid) {
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

        return countPaths(intGrid, grid.size(), grid.get(0).length());
    }

    private static int countPaths(int[][] grid, int N, int M) {
        // error checking
        if (grid == null || N <=0 || M <= 0) {
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
    private static int countPathsRec(int[][] grid, int N, int M, int i, int j, int[][] pathCount) {
        // error checking
        if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == 1) {
            return 0;
        }

        // computer path count already?
        if (pathCount[i][j] != -1) {
            return pathCount[i][j];
        }

        // compute pathCount based on varios paths forward
        pathCount[i][j] = countPathsRec(grid, N, M, i-1, j, pathCount) +
                          countPathsRec(grid, N, M, i, j+1, pathCount);

        return pathCount[i][j];
    }
}
