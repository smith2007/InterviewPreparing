package trie;

public class LongestDuplicateSubstringTrie {

  public static void main(String[] args) {

  }

  static class Trie {

    Trie[] children;
    final int startPos;
    final int depth;

    Trie(int startPos, int depth) {
      this.startPos = startPos;
      this.depth = depth;
    }

    boolean isBottom() {
      return children == null;
    }

    int childIndex(int start, String s) {
      return s.charAt(start + depth) - 'a';
    }

    //будет возвращать глубину
    int addNew(int start, String s) {
      if (start + depth == s.length()) {
        return depth;
      }

      if (isBottom()) {
        children = new Trie[28];
        children[childIndex(startPos, s)] = new Trie(startPos, depth + 1);
      }

      int newIndex = childIndex(start, s);
      Trie child = children[newIndex];
      if (child == null) {
        children[newIndex] = new Trie(start, depth + 1);
        return depth;
      }
      return child.addNew(start, s);
    }
  }

  public String longestDupSubstring(String str) {
    int maxStart = 0, maxLength = 0;
    int length = str.length();
    Trie root = new Trie(0, 0);
    for (int i = 1; i + maxLength < length; ++i) {
      int len = root.addNew(i, str);
      if (len > maxLength) {
        maxLength = len;
        maxStart = i;
      }
    }
    return str.substring(maxStart, maxStart + maxLength);
  }
}
