package trie;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWordDataStructureDesign {

  public static void main(String[] args) {

    AddAndSearchWordDataStructureDesign ins = new AddAndSearchWordDataStructureDesign();
    ins.addWord("a");
    //ins.addWord("vasya");

    System.out.println(ins.search("a"));/*
    System.out.println(ins.search("andr"));

    System.out.println(ins.search("vasya"));
    System.out.println(ins.search("vasyan"));*/


  }

  HashMap<Character, Node> roots = new HashMap<>();

  public AddAndSearchWordDataStructureDesign() {

  }

  public void addWord(String word) {

    if (word == null) {
      return;
    }

    char[] chars = word.toCharArray();

    Node curr = roots.get(chars[0]);
    if (curr == null) {
      curr = new Node(chars.length == 1, new HashMap<>());
      roots.put(chars[0], curr);
    } else {
      curr.isFinal = chars.length == 1;
    }

    for (int i = 1; i < chars.length; i++) {
      HashMap<Character, Node> map = curr.map;
      Node node = map.get(chars[i]);
      if (node == null) {
        node = new Node(chars.length - 1 == i, new HashMap<>());
        map.put(chars[i], node);
      } else {
        node.isFinal = chars.length - 1 == i;
      }
      curr = node;
    }

  }

  public boolean search(String word) {

    if (word == null || word.isEmpty()) {
      return false;
    }

    char[] chars = word.toCharArray();

    if (chars[0] == '.') {
			if (chars.length == 1) {
				return true;
			}
      return roots
          .values()
          .stream()
          .anyMatch(node -> search(word.substring(1), node.map));
    } else {
      Node curr = roots.get(chars[0]);
      if (curr == null) {
        return false;
      }
      Node node = roots.get(chars[0]);
      if (node == null) {
        return false;
      }

      if (chars.length == 1 && node.isFinal){
      	return true;
			}
      return search(word.substring(1), node.map);
    }
  }

  private boolean search(String word, Map<Character, Node> localRoots) {
    if (word == null || word.isEmpty()) {
      return false;
    }

    char[] chars = word.toCharArray();

    if (chars[0] == '.') {
			if (chars.length == 1) {
				return true;
			}
      return localRoots.values().stream().anyMatch(node -> search(word.substring(1), node.map));
    }

    Node curr = localRoots.get(chars[0]);

    if (curr == null) {
      return false;
    }

    for (int i = 1; i < chars.length; i++) {

      Node node = curr.map.get(chars[i]);
      if (node == null) {
        return false;
      }

      if (i == chars.length - 1 && !node.isFinal) {
        return false;
      }
      curr = node;
    }

    return true;
  }


  static class Node {

    boolean isFinal;
    HashMap<Character, Node> map;

    public Node(boolean isFinal, HashMap<Character, Node> map) {
      this.isFinal = isFinal;
      this.map = map;
    }
  }
}
