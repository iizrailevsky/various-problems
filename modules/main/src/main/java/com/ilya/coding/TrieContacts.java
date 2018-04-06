package com.ilya.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrieContacts {
    private static TrieNode contactTrie = new TrieNode();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if (op != null && op.equals("add")) {
                addContact(contact);
            } else if (op != null && op.equals("find")) {
                System.out.println(findContact(contact));
            }
        }
    }

    // adds a contact to the list
    private static void addContact(String contact) {
        // error checking
        if (contact == null || contact.isEmpty()) {
            return;
        }

        // init variables
        TrieNode curNode = contactTrie;
        char curChar;
        Map<Character, TrieNode> children = null;
        TrieNode curChild = null;

        // populate the contact into the trie
        char[] chars = contact.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            curChar = chars[i];
            children = curNode.getChildren();
            curChild = children.get(curChar);
            if (curChild == null) {
                curChild = new TrieNode();
                children.put(curChar, curChild);
            }
            curNode = curChild;
        }

        // set the last node as complete word
        curNode.setCompleteWord(true);
    }

    // find count of contacts given partial name
    private static int findContact(String partial) {
        // error checking
        if (partial == null || partial.isEmpty()) {
            return -1;
        }

        // init variables
        int count = 0;
        TrieNode curNode = contactTrie;
        char curChar;
        Map<Character, TrieNode> children = null;
        TrieNode curChild = null;

        // go in trie as far as possible
        char[] chars = partial.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            curChar = chars[i];
            children = curNode.getChildren();
            curChild = children.get(curChar);
            if (curChild == null) {
                // can't find current character in trie - no matches
                return 0;
            }
            curNode = curChild;
        }

        // reached the end of partial match
        // now count how many complete words there are recursively
        return countCompleteWords(curNode);
    }

    // returns count of completed words
    private static int countCompleteWords(TrieNode curNode) {
        // error checking
        if (curNode == null) {
            return 0;
        }

        // init variables
        int count = 0;
        if (curNode.isCompleteWord()) {
            count++;
        }
        // go over children recursively and count complete words
        for (TrieNode child: curNode.getChildren().values()) {
            count += countCompleteWords(child);
        }

        return count;
    }
}

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

