package com.ilya.coding;

import java.util.*;

public class MatchingSubsequences {

    public static int numMatchingSubseq(String s, String[] words) {
        // error checking
        validateInput(s, words);

        Map<Character, List<Integer>> charToInds = getCharToInds(s);
        return countMatching(charToInds, words);
    }

    private static void validateInput(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    // generate char to list<indices> map
    private static Map<Character, List<Integer>> getCharToInds(String s) {
        Map<Character, List<Integer>> charToInds = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToInds.containsKey(c)) {
                charToInds.get(c).add(i);
            } else {
                List<Integer> inds = new ArrayList<>();
                inds.add(i);
                charToInds.put(c, inds);
            }
        }
        return charToInds;
    }

    private static int countMatching(Map<Character, List<Integer>> charToInds, String[] words) {
        int count = 0;

        for (String word: words) {
            Set<Integer> usedInds = new HashSet<>();
            boolean matching = true; // matching unless proved otherwise
            int prevInd = -1;

            // match this word
            for (int i = 0; i < word.length(); i++) {
                char wc = word.charAt(i);

                if (charToInds.containsKey(wc)) {
                    List<Integer> inds = charToInds.get(wc);

                    // get next available index
                    int wcInd = -1;

                    // try to find index after previous matched one
                    for (int ind: inds) {
                        if (!usedInds.contains(ind)) {
                            if (ind > prevInd) {
                                wcInd = ind;
                                usedInds.add(wcInd);
                                prevInd = wcInd;
                                break;
                            }
                        }
                    }

                    // found available index and current index > prev
                    if (wcInd == -1) {
                        matching = false;
                        continue;
                    }
                } else {
                    matching = false;
                    continue;
                }
            }

            if (matching) {
                System.out.println(word);
                count++;
            }
        }

        return count;
    }
}
