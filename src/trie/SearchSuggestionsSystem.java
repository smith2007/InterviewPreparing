package trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {

  public static void main(String[] args) {
    SearchSuggestionsSystem ss = new SearchSuggestionsSystem();
    String[] arr = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
    List<List<String>> mo = ss.suggestedProducts(arr, "mouse");
    for (List<String> list : mo) {
      for (String s : list) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  TrieNode root = new TrieNode("");

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> res = new ArrayList<>();

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

    String collector = "";
    for (char c : searchWord.toCharArray()) {
      collector += c;
      res.add(getLists(products, collector));
    }
    return res;
  }

  private List<String> getLists(String[] products, String searchWord) {
    TrieNode curr = root;
    for (char symb : searchWord.toCharArray()) {
      int index = symb - 'a';

      TrieNode child = curr.children[index];
      if (child == null) {
        return new ArrayList<>();
      }
      curr = child;
    }

    List<String> res = new ArrayList<>();
    dive(res, curr);
    return res;
  }


  void dive(List<String> res, TrieNode curr) {
    if (res.size() == 3) {
      return;
    }
    if (curr.word != null && !curr.word.isEmpty()) {
      res.add(curr.word);
    }
    for (int i = 0; i < curr.children.length; i++) {
      if (curr.children[i] != null) {
        dive(res, curr.children[i]);
      }
    }
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
