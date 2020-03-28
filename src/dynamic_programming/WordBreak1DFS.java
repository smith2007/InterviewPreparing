package dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak1DFS {

    public static void main(String[] args) {

        String s = "leetcode";

        List<String> dict = List.of("leet", "code");

        System.out.println(wordBreak(s, dict));
    }

    static boolean wordBreak(String s, List<String> dict) {
        // DFS
        Set<Integer> set = new HashSet<>();

        return dfs(s, 0, new HashSet<>(dict), set);
    }

    static boolean dfs(String s, int index, Set<String> dict, Set<Integer> visited) {
        // base case
        if (index == s.length()) {
            return true;
        }
        // check memory
        if (visited.contains(index)) {
            return false;
        }
        // recursion
        for (int i = index + 1; i <= s.length(); i++) {
            String t = s.substring(index, i);
            if (dict.contains(t))
                if (dfs(s, i, dict, visited)) {
                    return true;
                } else {
                    visited.add(i);
                }
        }
        visited.add(index);
        return false;
    }
}
