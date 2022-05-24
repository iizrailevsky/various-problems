package com.ilya.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testBasic() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertEquals(true, trie.search("apple"));   // return True
        assertEquals(false, trie.search("app"));     // return False
        assertEquals(true, trie.startsWith("app")); // return True
        trie.insert("app");
        assertEquals(true, trie.search("app"));     // return True
    }
}

