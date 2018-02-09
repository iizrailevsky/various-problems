package com.ilya.coding;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/*
* Finds all unique paths from source [0,0] to destination [N-1, M-1] in
* a given matrix.
 */
public class MatrixPaths {

    /**
     * Given a matrix of N x M, returns all unique paths
     * from source [0,0] to destination [N-1, M-1].
     * @param N - N dimension of matrix
     * @param M - M dimension of matrix
     * @return Set<String> of paths if found, empty Set otherwise
     */
    public Set<String> getAllPaths(int N, int M) {
        // error checking
        if (N <= 0 || M <= 0) {
            throw new IllegalArgumentException("Invalid matrix dimensions!");
        }

        // init variables
        Set<String> resultPaths = new HashSet<>();
        // memorize which paths from each point have been already computed
        boolean[][] mem = new boolean[N][M];

        // populate the paths set
        getAllPathsRec(N, M, 0, 0, "", resultPaths, mem);

        return resultPaths;
    }

    // recursively populate the paths
    private void getAllPathsRec(int N, int M, int x, int y, String prefix, Set<String> resultPaths, boolean[][] mem) {
        // error checking
        if (N <= 0 || M <= 0 || x >= N || y >= M || prefix == null || resultPaths == null || mem == null) {
            return;
        }

        // base case: reached the distination?
        if (x == N - 1 && y == M - 1) {
            resultPaths.add(prefix);
        }

        // calculate paths only if not calculated already
        //if (!mem[x][y]) {
            // try going right
            if (x < N - 1) {
                getAllPathsRec(N, M, x + 1, y, prefix + "R", resultPaths, mem);
            }

            // try going down
            if (y < M - 1) {
                getAllPathsRec(N, M, x, y + 1, prefix + "D", resultPaths, mem);
            }

            // set paths calculated for this point in the matrix
            //mem[x][y] = true;
        //}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        MatrixPaths mp = new MatrixPaths();
        Set<String> paths = mp.getAllPaths(N, M);
        paths.stream().forEach(System.out::println);
    }
}