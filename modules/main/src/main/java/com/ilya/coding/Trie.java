package com.ilya.coding;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Constraints:
 *  - 1 <= word.length, prefix.length <= 2000
 *  - word and prefix consist only of lowercase English letters
 *  - At most 3 * 104 calls in total will be made to insert, search, and startsWith
 *
 * Options: Store the characters in the trie as an n-ary tree (n - 26 ASCII lowercase chars) with root node and a Map of chars to TrieNode's.
 *          On insert - split the word intro chars, add the new TrieNode's to the Trie as needed and set isCompleteWord at the end.
 *          On search - split the word intro chars, iterate through the Maps of TrieNode's until the word chars are exhausted and found isCompleteWord.
 *          On startsWith - split the prefix intro chars, iterate through the Map of TrieNode's until the prefix chars are exhausted.
 */
public class Trie {

    private TrieNode root;

    /**
     * Initializes the trie object
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts the string word into the trie.
     * @param word
     */
    public void insert(String word) {
        // error checking
        if (word == null || word.isEmpty()) {
            return;
        }

        char[] chars = word.toCharArray();
        TrieNode cur = root;
        TrieNode cNode = null;
        char c;
        // go over the word chars and add them to the trie as needed
        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            cNode = cur.getChildren().get(c);
            // doesn't exist yet?
            if (cNode == null) {
                cNode = new TrieNode();
                cur.getChildren().put(c, cNode);
            }
            cur = cNode;

            // mark last trie node as isCompleteWord
            if (i == chars.length - 1) {
                cur.setCompleteWord(true);
            }
        }
    }

    /**
     *  Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
     * @param word
     * @return
     */
    public boolean search(String word) {
        // error checking
        if (word == null || word.isEmpty()) {
            return false;
        }

        char[] chars = word.toCharArray();
        TrieNode cur = root;
        TrieNode cNode = null;
        char c;
        int i = 0;
        // go over the word chars and search for them in the trie as needed
        for (i = 0; i < chars.length; i++) {
            c = chars[i];
            cNode = cur.getChildren().get(c);
            // character doesn't exist in the trie? not found
            if (cNode == null) {
                return false;
            }
            cur = cNode;
        }

        // reached end of the word and complete word?
        return (i == chars.length) ? cur.isCompleteWord() : false;
    }

    /**
     * Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        // error checking
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }

        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        TrieNode cNode = null;
        char c;
        int i = 0;
        // go over the prefix chars and search for them in the trie as needed
        for (i = 0; i < chars.length; i++) {
            c = chars[i];
            cNode = cur.getChildren().get(c);
            // character doesn't exist in the trie? not found
            if (cNode == null) {
                return false;
            }
            cur = cNode;
        }

        // reached end of the prefix?
        return (i == chars.length) ? true : false;
    }
}
