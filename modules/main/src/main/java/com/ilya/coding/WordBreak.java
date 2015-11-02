package com.ilya.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public WordBreak() {
        // TODO Auto-generated constructor stub
    }

    private static final String[] validWords = {"i", "like", "sam", "sung"};
    private final Set<String> dictionary = new HashSet<>(Arrays.asList(validWords));
    //private int counter = 0;

    /**
     * Returns true if the given string is word breakable,
     * false otherwise
     * @param s Given string
     * @return true if the given string is word breakable,
     */
    public boolean isWordBreakable(String s) {
        //System.out.println( "Counter: " + counter++ );
        // error checking
        if (s == null) {
            return false;
        }

        // base case - empty stirng
        if (s.isEmpty()) {
            return true;
        }

        // try increasing combination of string
        for (int i = 1; i <= s.length(); i++) {
            // both this combination is valid and rest breakable
            if (isValidWord(s.substring(0, i)) && isWordBreakable(s.substring(i))) {
                return true;
            }
        }

        // could not find breakable combination
        return false;
    }

    /**
     * Returns true if dictionary contains contains the given string,
     * false otherwise
     * @param s
     * @return
     */
    private boolean isValidWord(String s) {
        return dictionary.contains(s);
    }

    public static void main( String[] args )
    {
        System.out.println(new WordBreak().isWordBreakable("i"));
        System.out.println(new WordBreak().isWordBreakable("ilike"));
        System.out.println(new WordBreak().isWordBreakable("ilik"));
        System.out.println(new WordBreak().isWordBreakable("ilikesamahava"));
        System.out.println(new WordBreak().isWordBreakable("ilikesamsung"));
    }

}
