package com.ilya.coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUniqueNumbers {

    // returns a list of unique permutations of numbers
    public List<List<Integer>> permuteUnique(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return null;
        }

        // init variables
        Set<List<Integer>> res = new HashSet<List<Integer>>();


        // for each position, try inserting it into other positions
        for (int i = 0; i < nums.length; i++) {
            List<Integer> numList = new ArrayList<>();
            for (int x: nums) {
                numList.add(x);
            }
            // remove element at this position
            int p = numList.remove(i);
            // insert at each position
            for (int j = 0; j < numList.size(); j++) {
                List<Integer> numList1 = new ArrayList<>(numList);
                // insert at each location
                numList1.add(j, p);
                // add to result set
                res.add(numList1);
            }

        }

        return new ArrayList<>(res);
    }

    // returns a list of unique permutations of numbers
    public List<List<Integer>> permuteUniqueWithRec(int[] nums) {
        // error checking
        if (nums == null || nums.length == 0) {
            return null;
        }

        // init variables
        Set<List<Integer>> res = new HashSet<List<Integer>>();


        // for each position, try inserting it into other positions
        for (int i = 0; i < nums.length; i++) {
            List<Integer> numList = new ArrayList<>();
            for (int x: nums) {
                numList.add(x);
            }
            // remove element at this position
            int p = numList.remove(i);
            // insert at each position
            permuteUniqueRec(numList, 0, p, res);
        }

        return new ArrayList<>(res);
    }

    private void permuteUniqueRec(List<Integer> numList, int pos, int p, Set<List<Integer>> res) {
        if (pos < 0 || pos >= numList.size()) {
            return;
        }

        // copy list
        List<Integer> numList1 = new ArrayList<>(numList);
        // insert at each location
        numList1.add(pos, p);
        // add to result set
        res.add(numList1);
        if (pos < numList.size()) {
            permuteUniqueRec(numList, pos + 1, p, res);
        }


    }

    public static void main(String[] args) {
        List<List<Integer>> res = new PermuteUniqueNumbers().permuteUniqueWithRec(new int[] {1,1,2});
        for (List<Integer> i : res) {
            System.out.println(i);
        }
    }
}
