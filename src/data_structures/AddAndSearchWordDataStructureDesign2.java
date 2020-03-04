package data_structures;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordDataStructureDesign2 {

  public static void main(String[] args) {

    AddAndSearchWordDataStructureDesign2 ins = new AddAndSearchWordDataStructureDesign2();
    ins.addWord("a");
    //ins.addWord("vasya");

    System.out.println(ins.search("a"));/*
    System.out.println(ins.search("andr"));

    System.out.println(ins.search("vasya"));
    System.out.println(ins.search("vasyan"));*/


  }

  HashMap<Character, TrieNode> roots = new HashMap<>();

  public AddAndSearchWordDataStructureDesign2() {

  }

  static class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
  }

  private TrieNode root = new TrieNode();

  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.item = word;
  }

  public boolean search(String word) {
    return match(word.toCharArray(), 0, root);
  }

  private boolean match(char[] chars, int startIndex, TrieNode node) {
    if (startIndex == chars.length) {
      return !node.item.equals("");
    }

    char firstLetter = chars[startIndex];
    if (firstLetter != '.') {
      return node.children[firstLetter - 'a'] != null
          && match(chars, startIndex + 1, node.children[firstLetter - 'a']);
    } else {
      for (int i = 0; i < node.children.length; i++) {
        if (node.children[i] != null) {
          if (match(chars, startIndex + 1, node.children[i])) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
