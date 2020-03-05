package trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {

  public static void main(String[] args) {

  }

  TrieNode root = new TrieNode("");

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    if (products.length == 0 || searchWord == null || searchWord.isEmpty()) {
      return new ArrayList<>();
    }

    for (String product : products) {

      TrieNode curr = root;
      for (char letter : product.toCharArray()) {
        int index = letter - 'a';
        if (curr.children[index] == null) {
          curr.children[index] = new TrieNode("");
        }
        curr = curr.children[index];
      }
      curr.word = product;
    }

    return null;
  }

  static class TrieNode {

    TrieNode[] children;
    String word;

    public TrieNode(String word) {
      this.children = new TrieNode[26];
      this.word = word;
    }
  }
}
