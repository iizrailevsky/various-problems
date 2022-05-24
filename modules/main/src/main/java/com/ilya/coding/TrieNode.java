package com.ilya.coding;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isCompleteWord;

    // constructor
    public TrieNode() {
        children = new HashMap<>(23);
        isCompleteWord = false;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean isCompleteWord) {
        this.isCompleteWord = isCompleteWord;
    }
}


