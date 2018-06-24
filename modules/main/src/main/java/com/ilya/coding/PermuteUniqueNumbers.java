package com.ilya.coding;

import java.util.*;

public class PermuteUniqueNumbers {

    // returns a list of unique permutations of numbers
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // error checking
        if (nums == null) {
            return null;
        } else if (nums.length == 0) {
            return new ArrayList<>();
        }

        // init variables
        Set<List<Integer>> res = new HashSet<List<Integer>>();

        // take first element
        int p = nums[0];
        int[] restNums = Arrays.copyOfRange(nums, 1, nums.length);
        List<List<Integer>> permRest = permuteUnique(restNums);

        // empty case
        if (permRest.isEmpty()) {
            List<Integer> permNew = new ArrayList<>();
            permNew.add(p);
            res.add(permNew);
        }
        // insert p into each permutation of rest
        for (List<Integer> perm: permRest) {
            for (int i = 0; i <= perm.size(); i++) {
                List<Integer> permNew = new ArrayList<>(perm);
                permNew.add(i, p);
                res.add(permNew);
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permuteUnique(new int[] {1, 2, 3, 4});
        System.out.println(res.size());
        for (List<Integer> i : res) {
            System.out.println(i);
        }
        res = new PermuteUniqueNumbers().permuteUnique(new int[] {1,2,3,4,5});
        System.out.println(res.size());
        for (List<Integer> i : res) {
            System.out.println(i);
        }
    }
}
