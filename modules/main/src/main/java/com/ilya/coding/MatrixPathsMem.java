package com.ilya.coding;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Finds all unique paths from source [0,0] to destination [N-1, M-1] in
 * a given matrix with memorization.
 */
public class MatrixPathsMem {

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
        // memorize which paths from each point have been already computed
        @SuppressWarnings("unchecked")
        Set<String>[][] mem = (Set<String>[][]) Array.newInstance(Set.class, N, M);

        // populate the paths set
        return getAllPathsRec(N, M, 0, 0, mem);
    }

    // recursively populate the paths
    private Set<String> getAllPathsRec(int N, int M, int x, int y, Set<String>[][] mem) {
        // error checking
        if (N <= 0 || M <= 0 || x >= N || y >= M ||  mem == null) {
            return Collections.emptySet();
        }

        // base case: reached the distination?
        if (x == N - 1 && y == M - 1) {
            return Collections.emptySet();
        }

        // paths cal1culated already?
        if (mem[x][y] != null) {
            return mem[x][y];
        } else {
            // calculate paths only if not calculated already
            Set<String> pathsFromXY = new HashSet<>();

            // try going right
            if (x < N - 1) {
                Set<String> pathsFromX1Y = getAllPathsRec(N, M, x + 1, y, mem);
                if (pathsFromX1Y.isEmpty()) {
                    pathsFromXY.add("R");
                } else {
                    for (String s : pathsFromX1Y) {
                        pathsFromXY.add("R" + s);
                    }
                }
            }

            // try going down
            if (y < M - 1) {
                Set<String> pathsFromXY1 = getAllPathsRec(N, M, x, y + 1, mem);
                if (pathsFromXY1.isEmpty()) {
                    pathsFromXY.add("D");
                } else {
                    for (String s : pathsFromXY1) {
                        pathsFromXY.add("D" + s);
                    }
                }
            }

            mem[x][y] = pathsFromXY;
            return mem[x][y];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        MatrixPathsMem mp = new MatrixPathsMem();
        Instant first = Instant.now();
        Set<String> paths = mp.getAllPaths(N, M);
        Instant second = Instant.now();
        System.out.println("Time: " + Duration.between(first, second).toMillis());
        System.out.println("Total: " + paths.size());
        paths.forEach(System.out::println);
    }
}