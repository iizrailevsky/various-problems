package com.ilya.coding;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GridRegions {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        scanner.close();

        System.out.println(getSizeOfBiggestRegion(grid, n, m));
    }

    // returns the size of the biggest region in a given matrix,
    // if found, 0 otherwise
    public static int getSizeOfBiggestRegion(int[][] grid, int n, int m) {
        // error checking
        if (grid == null || grid.length == 0 || n <= 0 || m <= 0) {
            return 0;
        }

        // init variables
        boolean[][] visited = new boolean[n][m];
        List<Coordinate> q = null;
        int count = 0;
        int maxSize = 0;

        // go over grid, find 1 not yet visited
        // and traverse its region BFS and get its size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // found region with 1 not visited? traverse
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q = new ArrayList<>();
                    count = 0;
                    q.add(new Coordinate(i, j));

                    for (int x = 0; x < q.size(); x++) {
                        Coordinate curr = q.get(x);
                        // visited? then skip
                        if (visited[curr.i][curr.j]) {
                            continue;
                        }
                        visited[curr.i][curr.j] = true;
                        count++;
                        List<Coordinate> adjacentList = getAdjacent(curr, grid, n, m);
                        for (Coordinate adjacent: adjacentList) {
                            if (!visited[adjacent.i][adjacent.j]) {
                                q.add(adjacent);
                            }
                        }
                    }

                    // found biggest region?
                    if (count > maxSize) {
                        maxSize = count;
                    }
                }
            }
        }

        return maxSize;
    }

    private static List<Coordinate> getAdjacent(Coordinate curr, int[][] grid, int n, int m) {
        // error checking
        if (curr == null || grid == null || n <= 0 || m <= 0) {
            return new ArrayList<Coordinate>(0);
        }

        // init variables
        List<Coordinate> resList = new ArrayList<>();
        int i = curr.i;
        int j = curr.j;

        if (i-1 >= 0 && i-1 < n) {
            if (j-1 >= 0 && j-1 < m) {
                if (grid[i-1][j-1] == 1) {
                    resList.add(new Coordinate(i-1, j-1));
                }
            }
            if (grid[i-1][j] == 1) {
                resList.add(new Coordinate(i-1, j));
            }
            if (j+1 >= 0 && j+1 < m) {
                if (grid[i-1][j+1] == 1) {
                    resList.add(new Coordinate(i-1, j+1));
                }
            }
        }
        if (j-1 >= 0 && j-1 < m) {
            if (grid[i][j-1] == 1) {
                resList.add(new Coordinate(i, j-1));
            }
        }
        if (j+1 >= 0 && j+1 < m) {
            if (grid[i][j+1] == 1) {
                resList.add(new Coordinate(i, j+1));
            }
        }
        if (i+1 >= 0 && i+1 < n) {
            if (j-1 >= 0 && j-1 < m) {
                if (grid[i+1][j-1] == 1) {
                    resList.add(new Coordinate(i+1, j-1));
                }
            }
            if (grid[i+1][j] == 1) {
                resList.add(new Coordinate(i+1, j));
            }
            if (j+1 >= 0 && j+1 < m) {
                if (grid[i+1][j+1] == 1) {
                    resList.add(new Coordinate(i+1, j+1));
                }
            }
        }

        return resList;
    }
}

class Coordinate {

    protected int i;
    protected int j;

    // constructor
    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return i == that.i &&
                j == that.j;
    }

    @Override
    public int hashCode() {

        return Objects.hash(i, j);
    }
}

