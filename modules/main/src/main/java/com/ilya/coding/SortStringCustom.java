package com.ilya.coding;

import java.util.*;

public class SortStringCustom {

    public static String customSortString(String S, String T) {
        if (S == null || S.isEmpty() || T == null || T.isEmpty()) {
            return T;
        }

        Map<Character, Integer> charToPosition = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            charToPosition.put(S.charAt(i), i);
        }

        List<Character> tChars = new ArrayList();
        for (char c : T.toCharArray()) {
            tChars.add(c);
        }
        Collections.sort(tChars, new SortStringCustomComparator(charToPosition));

        StringBuilder sb = new StringBuilder();
        for (Character c : tChars) {
            sb.append(c);
        }
        return sb.toString();
    }
}

class SortStringCustomComparator implements Comparator<Character> {

    private Map<Character, Integer> charToPosition;

    public SortStringCustomComparator(Map<Character, Integer> charToPosition) {
        this.charToPosition = charToPosition;
    }

    @Override
    public int compare(Character o1, Character o2) {
        if (o1.equals(o2)) {
            return 0;
        }

        int pos1 = (charToPosition.containsKey(o1)) ? charToPosition.get(o1) : Integer.MIN_VALUE;
        int pos2 = (charToPosition.containsKey(o2)) ? charToPosition.get(o2) : Integer.MIN_VALUE;
        return (pos1 < pos2) ? -1 : 1;
    }
}