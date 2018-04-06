package com.ilya.coding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FavoriteCommonRestaurants {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] a = new String[0];
        String[] b = new String[0];

        for (int i = 0; i < 2; i++) {
            String line = in.nextLine();
            if (i == 0) {
                a = line.split(" ");
            } else if (i == 1) {
                b = line.split(" ");
            }
        }

        System.out.println(getFavoriteCommonRestaurants(a, b));

    }

    // returns a list of restaurants with most favorite common rankings
    public static List<String> getFavoriteCommonRestaurants(String[] a, String[] b) {
        // error checking
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return new ArrayList<>();
        }

        // init variables
        Map<String, Integer> rankingA = new HashMap<>();
        Map<String, Integer> rankingB = new HashMap<>();
        List<String> res = new ArrayList<>();
        int minRankingSum = Integer.MAX_VALUE;

        // populate ranking maps
        for (int i = 0; i < a.length; i++) {
            if (!rankingA.containsKey(a[i])) {
                rankingA.put(a[i], i);
            }
        }
        for (int j = 0; j < b.length; j++) {
            if (!rankingB.containsKey(b[j])) {
                rankingB.put(b[j], j);
            }
        }

        // go through rankingA and check if exists in rankingB
        // and keep track of min sum
        for (String restA: rankingA.keySet()) {
            if (rankingB.containsKey(restA)) {
                int curSum = rankingA.get(restA) + rankingB.get(restA);

                // is multiple min ranking?
                if (curSum == minRankingSum) {
                    res.add(restA);
                } else if (curSum < minRankingSum) {
                    // remove older list
                    res.clear();
                    res.add(restA);
                    minRankingSum = curSum;
                }
            }
        }

        return res;
    }
}
