package org.example.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public String result;
    public Map<String, TrieNode> childNodes;

    public TrieNode(String result) {
        childNodes = new HashMap<>();
        this.result = result;
    }

    public TrieNode() {
        childNodes = new HashMap<>();
    }
}
