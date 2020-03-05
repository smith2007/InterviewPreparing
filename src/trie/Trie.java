package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }


    static class Node {
        char ch;
        boolean isFinal;
        Map<Character, Node> map;

        Node(char ch) {
            this.ch = ch;
            this.map = new HashMap<>();
            this.isFinal = false;
        }

        Node() {
            this.map = new HashMap<>();
            this.isFinal = false;
        }
    }


    Node initial;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.initial = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        Node curr = initial;

        for (int i = 0; i < word.length(); i++) {
            Node next = curr.map.get(word.charAt(i));
            if (next == null) {
                next = new Node(word.charAt(i));
                curr.map.put(word.charAt(i), next);
            }
            curr = next;
        }
        curr.isFinal = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        Node curr = initial;
        for (int i = 0; i < word.length(); i++) {
            Node next = curr.map.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return curr.isFinal;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }

        Node curr = initial;
        for (int i = 0; i < prefix.length(); i++) {
            Node next = curr.map.get(prefix.charAt(i));
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return true;
    }

}
