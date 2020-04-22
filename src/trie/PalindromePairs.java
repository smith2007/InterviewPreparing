package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

  /**
   * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
   *
   * Example 1:
   *
   * Input: ["abcd","dcba","lls","s","sssll"]
   * Output: [[0,1],[1,0],[3,2],[2,4]]
   * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
   * Example 2:
   *
   * Input: ["bat","tab","cat"]
   * Output: [[0,1],[1,0]]
   * Explanation: The palindromes are ["battab","tabbat"]
   *
   *
   * https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
   */


  private static class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;

    TrieNode() {
      next = new TrieNode[26];
      index = -1;
      list = new ArrayList<>();
    }
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();

    TrieNode root = new TrieNode();

    for (int i = 0; i < words.length; i++) {
      addWord(root, words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      search(words, i, root, res);
    }

    return res;
  }

  private void addWord(TrieNode root, String word, int index) {
    for (int i = word.length() - 1; i >= 0; i--) {
      int j = word.charAt(i) - 'a';

      if (root.next[j] == null) {
        root.next[j] = new TrieNode();
      }

      if (isPalindrome(word, 0, i)) {
        root.list.add(index);
      }

      root = root.next[j];
    }

    root.list.add(index);
    root.index = index;
  }

  private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
    for (int j = 0; j < words[i].length(); j++) {
      if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
        res.add(Arrays.asList(i, root.index));
      }

      root = root.next[words[i].charAt(j) - 'a'];
      if (root == null) return;
    }

    for (int j : root.list) {
      if (i == j) continue;
      res.add(Arrays.asList(i, j));
    }
  }

  private boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) return false;
    }

    return true;
  }
}