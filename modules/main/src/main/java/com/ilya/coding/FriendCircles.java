package com.ilya.coding;

import java.util.ArrayList;
import java.util.List;

public class FriendCircles {

    // returns number of friend circles
    public static int findCircleNum(int[][] M) {
        // error checking
        if (M == null || M.length == 0) {
            return -1;
        }

        // init variables
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        // go over M, find 1 not yet visited
        // and traverse its region DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, visited, n, i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int[][] M, boolean visited[], int n, int i) {
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, n, j);
            }
        }
    }

}
