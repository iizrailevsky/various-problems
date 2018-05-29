package com.ilya.coding;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by iizrailevsky on 4/27/18.
 */
public class LengthOfLongestSubstring {

    /**
     * Returns length of the longest substring given a string
     * @param s
     * @return length of the longest substring given a string if found, 0 otherwise
     */
    public int lengthOfLongestSubstring(String s) {
        // error checking
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        // init variables
        PriorityQueue<String> q = new PriorityQueue<>(100, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return 0;
                return (o1.length() > o2.length()) ? -1 : 1;
            }
        });

        // recursively collect longest unique substrings
        collectLongestUniqueSubstring(s, q);

        String longestSub = q.peek();
        System.out.println(longestSub);
        return (longestSub != null) ? longestSub.length() : 0;
    }

    // recursively collect unique substrings
    private void collectLongestUniqueSubstring(String s, PriorityQueue<String> q) {
        // error checking
        if (s == null || s.length() == 0) {
            return;
        } else if (s.length() == 1) {
            q.add(s);
            return;
        }

        // init variables
        char[] chars = s.toCharArray();
        byte[] unique = new byte[256];
        StringBuilder sb = new StringBuilder();

        // go over string and find unique substrings
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // found dup char?
            if (unique[c] != 0) {
                break;
            } else {
                unique[c] = 1;
                sb.append(c);
            }
        }

        // add substring to q
        if(sb.length() != 0) {
            q.add(sb.toString());
        }


        // continue collecting unique substrings
        collectLongestUniqueSubstring(s.substring(1), q);
    }
}
