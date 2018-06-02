package com.ilya.coding;

import java.util.*;

public class SortImageFiles {

    public static void sortTheFilesWithSort(int n, List<String> result) {
        // error checking
        if (n <= 0 || n > 1000000) {
            throw new IllegalArgumentException("Invalid input n: " + n);
        }

        if (n > 10000) {
            n = 10000;
        }

        // init variables

        // populate list of files
        for (int i = 1; i <= n; i++) {
            result.add("IMG" + i + ".jpg");
        }
        // sort lexicographically
        Collections.sort(result);

    }

    // returns image files up to n number sorted lexicographically,
    // returning up to 1000 first numbers
    public static void sortTheFiles(int n, List<String> result) {
        // error checking
        if (n <= 0 || result == null) {
            return;
        }

        // init variables
        int MAX_SIZE = 1000;

        // recursively go over lexicographical  number tree
        sortTheFilesRec(n, 0, 0, MAX_SIZE, result);
    }

    // returns image files up to n number tree and add file names
    private static void sortTheFilesRec(int n, int num, int level, int MAX_SIZE, List<String> result) {
        // error checking
        if (n <= 0 || num > n || result.size() >= MAX_SIZE) {
            return;
        }

        // add num for file if valid
        if (level > 0) {
            result.add("IMG" + num + ".jpg");
        }

        // go over subtrees and add digits
        for (int i = 0; i <= 9; i++) {
            if (level == 0 && i == 0) continue;
            sortTheFilesRec(n, (num * 10) + i, level + 1, MAX_SIZE, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        SortImageFiles.sortTheFiles(10008, result);
        result.forEach(System.out::println);
    }
}
