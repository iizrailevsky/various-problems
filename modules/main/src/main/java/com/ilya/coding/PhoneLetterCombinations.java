package com.ilya.coding;

import java.util.*;

public class PhoneLetterCombinations {

    // map of phone digis to letters
    private static Map<Character, List<Character>> digitToCharMap = new HashMap<>();

    static {
        digitToCharMap.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        digitToCharMap.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        digitToCharMap.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        digitToCharMap.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        digitToCharMap.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        digitToCharMap.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        digitToCharMap.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        digitToCharMap.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }

    // returns letter combinations for a given phone number digits if found, null otherwise
    public static List<String> letterCombinations(String digits) {
        // error checking
        if (digits == null) {
            return null;
        } else if (digits.length() == 0) {
            return new ArrayList<>(0);
        }

        // init variables
        List<String> letterCombos = new ArrayList<>();
        int n = digits.length();

        // recursively construct letter combinations
        letterCombinationsRec(digits, n, 0, "", letterCombos);
        return letterCombos;
    }

    // recursively construct letter combinations
    private static void letterCombinationsRec(String digits, int n, int index, String prefix, List<String> letterCombos) {
        // error checking and base case
        // reached end of phone digits
        if (index >= n) {
            letterCombos.add(prefix);
            return;
        } else if (!digitToCharMap.containsKey(digits.charAt(index))) {
            throw new IllegalArgumentException("Invalid digit: " + digits.charAt(index));
        }

        // go over each possible letter of current digit
        List<Character> chars = digitToCharMap.get(digits.charAt(index));
        for (char c: chars) {
            letterCombinationsRec(digits, n, index + 1, prefix + c, letterCombos);
        }
    }


}
