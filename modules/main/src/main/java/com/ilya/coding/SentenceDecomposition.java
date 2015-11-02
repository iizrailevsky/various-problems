/**
 *
 */
package com.ilya.coding;

import java.util.Arrays;

/**
 *
 * SentenceDecomposition - TopCoder
 *
 *
 * @author iizrailevsky
 *
 */
public class SentenceDecomposition {

    /**
     *
     */
    public SentenceDecomposition() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Given a String sentence, return the total cost of transformation
     * of the sequence of valid words which carries the meaning of the sentence,
     * or -1 if no such sequence exists
     *
     *
     * @param sentence
     * @param validWords
     * @return
     */
    public int decompose(String sentence, String[] validWords) {
        // error checking
        if (sentence == null || validWords == null || validWords.length == 0) {
            return -1;
        }

        // base case
        if (sentence.isEmpty()) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        // go through the sentence and try to decompose
        for (int i = 1; i <= sentence.length(); i++) {
            int transformCostInit = findMinTranformCost(sentence.substring(0, i), validWords);
            if (transformCostInit >= 0) {
                int tranformCostRest = decompose(sentence.substring(i), validWords);
                if (tranformCostRest >= 0) {
                    int cost = transformCostInit + tranformCostRest;
                    if (cost < minCost) {
                        minCost = cost;
                    }
                }

            }
        }

        return (minCost < Integer.MAX_VALUE) ? minCost : -1;
    }

    /**
     * Calculates min transform cost.
     *
     * The cost to transform a word is defined as the number of character positions
     * where the original word and the transformed word differ.
     *
     * @param sentence
     * @param validWords
     * @return
     */
    private int findMinTranformCost(String s, String[] validWords) {
        // error checking / handling
        if (s == null || s.isEmpty() || validWords == null || validWords.length == 0) {
            return -1;
        }

        int minCost = Integer.MAX_VALUE;

        // go over valid words and match of length first
        for (String validWord: validWords) {
            if (s.length() == validWord.length()) {
                char[] sChars = s.toCharArray();
                char[] vChars = validWord.toCharArray();

                // sort both to find match
                char[] sCharsSorted = Arrays.copyOf(sChars, sChars.length);
                char[] vCharsSorted = Arrays.copyOf(vChars, vChars.length);
                Arrays.sort(sCharsSorted, 0, sCharsSorted.length);
                Arrays.sort(vCharsSorted, 0, vCharsSorted.length);

                // exact match?
                if (Arrays.toString(sCharsSorted).equals(Arrays.toString(vCharsSorted))) {
                    int cost = findTransformCost(sChars, vChars);
                    if (cost < minCost) {
                        minCost = cost;
                    }
                }
            }
        }

        return (minCost < Integer.MAX_VALUE) ? minCost : -1;
    }

    /**
     * Finds tranform cost between 2 char arrays of same length
     *
     * The cost to transform a word is defined as the number of character positions
     * where the original word and the transformed word differ.
     *
     * @param a
     * @param b
     * @return tranform cost
     */
    private int findTransformCost(char[] a, char[] b) {
        int diffCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                diffCount++;
            }
        }

        return diffCount;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Cost of tranformation: " + new SentenceDecomposition()
                            .decompose("neotowheret", new String[] {"one", "two", "three", "there"}));
        System.out.println("Cost of tranformation: " + new SentenceDecomposition()
                            .decompose("abba", new String[] {"ab", "ac", "ad"}));
        System.out.println("Cost of tranformation: " + new SentenceDecomposition()
                            .decompose("thisismeaningless", new String[] {"this", "is", "meaningful"}));
        System.out.println("Cost of tranformation: " + new SentenceDecomposition()
                            .decompose("ommwreehisymkiml",
                new String[] {"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"}));
        System.out.println("Cost of tranformation: " + new SentenceDecomposition()
                            .decompose("ogodtsneeencs", new String[] {"go", "good", "do", "sentences", "tense", "scen"}));
        System.out.println("Cost of tranformation: " + new SentenceDecomposition()
                            .decompose("sepawaterords", new String[] {"separate","words"}));
    }

}
