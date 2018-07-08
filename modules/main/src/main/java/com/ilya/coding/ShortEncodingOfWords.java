package com.ilya.coding;

import java.util.*;

public class ShortEncodingOfWords {

    // encodes ["time", "me", "bell"], as S = "time#bell#" and indexes = [0, 2, 5]
    public static int minimumLengthEncoding(String[] words) {
        // error checking
        validateInput(words);
        Set<String> wordSet = getWordSet(words);
        Map<String, List<Integer>> wordToInds = collapseWords(wordSet);
        int[] inds = new int[words.length];
        String s = encodeWords(wordToInds, inds);
        System.out.println(s);
        System.out.println(Arrays.toString(inds));
        return s.length();
    }

    private static void validateInput(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Illegal input!");
        }
    }

    private static Set<String> getWordSet(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for (String w : words) {
            wordSet.add(w);
        }
        return wordSet;
    }

    private static Map<String, List<Integer>> collapseWords(Set<String> wordSet) {
        Map<String, List<Integer>> wordToInds = new HashMap<>();
        Set<String> skipSet = new HashSet<>();
        for (String word : wordSet) {
            if (skipSet.contains(word)) {
                continue;
            }
            List<Integer> inds = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                String subWord = word.substring(i);
                if (wordSet.contains(subWord) && !skipSet.contains(subWord)) {
                    // add subWord to skipSet
                    if (!subWord.equals(word)) {
                        skipSet.add(subWord);
                    }
                    // remove subWord from wordToInds map and add to skipSet if exists already
                    // and transfer its indices here
                    if (!subWord.equals(word) && wordToInds.containsKey(subWord)) {
                        List<Integer> subWordInds = wordToInds.get(subWord);
                        for (int j : subWordInds) {
                            inds.add(i + j);
                        }
                        wordToInds.remove(subWord);
                    } else {
                        inds.add(i);
                    }
                }
            }
            wordToInds.put(word, inds);
        }
        return wordToInds;
    }

    private static String encodeWords(Map<String, List<Integer>> wordToInds, int[] inds) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int index = 0;

        for (Map.Entry<String, List<Integer>> entry : wordToInds.entrySet()) {
            sb.append(entry.getKey()).append("#");
            for (int i : entry.getValue()) {
                inds[index++] = pos + i;
            }
            // increment position and index
            pos += entry.getKey().length() + 1;
        }
        return sb.toString();
    }
}
