package com.ilya.coding;

import java.util.*;

public class PermuteUniqueNumbers {

    /**
     * Given an array of distinct integers, return all the possible permutations.
     * You can return the answer in any order.
     *
     * Input: int[] nums - distinct integers
     * Output: List<List<Integer>> - list of all possible permutations
     * Contraints: Positive, negative, unique numbers
     * Options: Single number: [1] -> [[1]]
     *          2 numbers: [0, 1] -> [[0, 1], [1, 0]]
     *          3 numbers [0,1,2]: Chop off last element and insert 2 at each spot for 2 perm:
     *            merge: [2,0,1], [0,2,1], [0,1,2]
     *            merge: [2,1,0], [1,2,0], [1,0,2] to:
     *            [[2,0,1], [0,2,1], [0,1,2], [2,1,0], [1,2,0], [1,0,2]]
     * Time: O(n!)
     * Space: O(n! * n)
     */
    public static List<List<Integer>> permute(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> numsList = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }

        return permute(numsList);
    }

    private static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.size();

        // base cases
        // [1] -> [[1]]
        if (size == 1) {
            res.add(new ArrayList<>(nums));
        } else if (size == 2) {
            // [0, 1] -> [[0, 1], [1, 0]]
            res.add(new ArrayList<>(nums));
            List<Integer> reverse = new ArrayList<>(nums);
            Collections.reverse(reverse);
            res.add(reverse);
        } else {
            // chop off last element
            int last = nums.remove(size - 1);
            List<List<Integer>> prevPerms = permute(nums);

            // insert it at each spot for previous permutations
            for (List<Integer> prev: prevPerms) {
                for (int i = 0; i < prev.size(); i++) {
                    List<Integer> prevCopy = new ArrayList<>(prev);
                    prevCopy.add(i, last);
                    res.add(prevCopy);
                }
                // append at the end
                List<Integer> prevCopy = new ArrayList<>(prev);
                prevCopy.add(last);
                res.add(prevCopy);
            }
        }

        return res;
    }


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
        res = new PermuteUniqueNumbers().permute(new int[] {1,2,3,4,5});
        System.out.println(res.size());
        for (List<Integer> i : res) {
            System.out.println(i);
        }
    }
}
