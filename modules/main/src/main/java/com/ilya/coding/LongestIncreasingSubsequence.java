package com.ilya.coding;

import java.util.*;

public class LongestIncreasingSubsequence {

    public static List<Integer> getLongestIncreasingSubsequence(List<Integer> sequence) {
        // error checking
        if (sequence == null || sequence.isEmpty()) {
            return new ArrayList<Integer>(0);
        }
        if (sequence.size() == 1) {
            return sequence;
        }

        // init variables
        int n = sequence.size();
        Map<Integer, List<Integer>> longestSeqMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        List<Integer> currList = null;
        List<Integer> maxList = null;
        int ultimateMaxLength = 0;
        List<Integer> ultimateMaxList = null;

        // backtrack from end and store longest subsequences starting at each element
        for (int i = n - 1; i >= 0; i--) {
            maxLength = 0;
            start = sequence.get(i);
            maxList = null;
            // go over calculated longest subsequences and find longest subsequences which can work
            for (int j = i + 1; j < n; j++) {
                currList = longestSeqMap.get(j);
                // start is less than calculated subsequence
                if (currList != null && !currList.isEmpty() && maxLength < currList.size() && start < currList.get(0)) {
                    maxList = new ArrayList<>();
                    maxList.add(start);
                    maxList.addAll(currList);
                    maxLength = maxList.size();
                }
            }
            if (maxList == null) {
                maxList = new ArrayList<>(1);
                maxList.add(start);
                maxLength = 1;
            }
            longestSeqMap.put(i, maxList);

            // found ultimate max subsequence
            if (maxLength > ultimateMaxLength) {
                ultimateMaxList = maxList;
                ultimateMaxLength = maxList.size();
            }
        }

        return ultimateMaxList;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(LongestIncreasingSubsequence.getLongestIncreasingSubsequence(new ArrayList<>()));
        list.add(14);
        System.out.println(LongestIncreasingSubsequence.getLongestIncreasingSubsequence(list));

        list.clear();
        list.add(16);
        list.add(3);
        list.add(5);
        list.add(19);
        list.add(10);
        list.add(14);
        list.add(12);
        list.add(0);
        list.add(15);
        System.out.println(LongestIncreasingSubsequence.getLongestIncreasingSubsequence(list));

        list.clear();
        list.add(10);
        list.add(8);
        list.add(6);
        list.add(4);
        list.add(2);
        list.add(0);
        System.out.println(LongestIncreasingSubsequence.getLongestIncreasingSubsequence(list));
    }
}
