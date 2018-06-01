package com.ilya.coding;

import java.util.*;

public class SortImageFiles {

    public static void sortTheFiles(int n, List<String> result) {
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

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        SortImageFiles.sortTheFiles(10000, result);
        result.forEach(System.out::println);
    }
}
