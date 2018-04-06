package com.ilya.coding;

import java.time.Duration;
import java.time.Instant;
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

        // populate the paths set
        getAllPathsRec(N, M, 0, 0, "", resultPaths);

        return resultPaths;
    }

    // recursively populate the paths
    private void getAllPathsRec(int N, int M, int x, int y, String prefix, Set<String> resultPaths) {
        // error checking
        if (N <= 0 || M <= 0 || x >= N || y >= M || prefix == null || resultPaths == null) {
            return;
        }

        // base case: reached the distination?
        if (x == N - 1 && y == M - 1) {
            resultPaths.add(prefix);
        }

        // try going right
        if (x < N - 1) {
            getAllPathsRec(N, M, x + 1, y, prefix + "R", resultPaths);
        }

        // try going down
        if (y < M - 1) {
            getAllPathsRec(N, M, x, y + 1, prefix + "D", resultPaths);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        MatrixPaths mp = new MatrixPaths();
        Instant first = Instant.now();
        Set<String> paths = mp.getAllPaths(N, M);
        Instant second = Instant.now();
        System.out.println("Time: " + Duration.between(first, second).toMillis());
        System.out.println("Total: " + paths.size());
        paths.forEach(System.out::println);
    }
}