package com.ilya.coding;

import java.util.*;

public class ShortestCompletingWord {

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        // error checking
        if (licensePlate == null || licensePlate.isEmpty() || words == null || words.length == 0) {
            return null;
        }

        // sort words from shortest to longest
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) { return 0; }
                return (o1.length() < o2.length()) ? -1 : 1;
            }
        });

        for (String w : words) {
            if (isExpired(stringToMap(licensePlate), stringToMap(w))) {
                return w;
            }
        }

        return null;
    }

    private static Map<Character, Integer> stringToMap(String s) {
        Map<Character, Integer> map = new HashMap();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        return map;
    }

    private static boolean isExpired(Map<Character, Integer> lpm, Map<Character, Integer> wm) {
        for (Map.Entry<Character, Integer> lpme : lpm.entrySet()) {
            if (wm.containsKey(lpme.getKey())) {
                // license plate char has more occurrences than the word?
                // then this is not a completed word
                if (lpme.getValue() > wm.get(lpme.getKey())) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
