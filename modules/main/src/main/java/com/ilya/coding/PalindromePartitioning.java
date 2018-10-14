package com.ilya.coding;

import java.util.*;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return Collections.EMPTY_LIST;
        }

        List<List<String>> res = new ArrayList();

        // try the rest of string
        for (int i = 1; i <= s.length(); i++) {
            String start = s.substring(0, i);
            if (isPalindrome(start)) {
                List<List<String>> restRes = partition(s.substring(i));
                if (restRes == Collections.EMPTY_LIST) {
                    res.add(new ArrayList() {{ add(start); }});
                } else if (!restRes.isEmpty()) {
                    // add these partitions to the result
                    for (List<String> l : restRes) {
                        l.add(0, start);
                        res.add(l);
                    }
                }
            }
        }

        return res;
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        } else if (s.length() == 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


}
