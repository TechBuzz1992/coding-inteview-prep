package amazon;

import java.util.*;

public class Trie {

    class TrieNode {
        HashMap<Character, TrieNode> map;
        char character;
        boolean last;

        TrieNode(char c) {

            this.map = new HashMap<>();
            this.character = c;
            this.last = false;

        }

    }

    private TrieNode root;

    Trie() {
        this.root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.map.containsKey(c)) {
                current.map.put(c, new TrieNode(c));

            }

            current = current.map.get(c);

        }

        current.last = true;
    }

    public boolean search(String str) {
        TrieNode current = root;

        for (char c : str.toCharArray()) {
            if (!current.map.containsKey(c)) {
                return false;
            }

            current = current.map.get(c);
        }

        if (current.last == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchPrefix(String str) {
        TrieNode current = root;
        for (char c : str.toCharArray()) {
            if (!current.map.containsKey(c)) {

                return false;
            }
        }

        return true;
    }

}