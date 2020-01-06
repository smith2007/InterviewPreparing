package bfs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> hot = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, hot));
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);

        // Use queue to help BFS
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Mark visited word
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size != 0) {
                String polledWord = queue.poll();
                if (endWord.equals(polledWord) && wordSet.contains(polledWord)) {
                    return level;
                } else if (wordSet.contains(polledWord)) {
                    for (int i = 0; i < polledWord.length(); i++) {
                        char[] charArray = polledWord.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            charArray[i] = c;
                            String newWord = new String(charArray);
                            if (!visited.contains(newWord)) {
                                visited.add(newWord);
                                queue.add(newWord);
                            }

                        }
                    }
                }
                size--;
            }
        }
        return 0;
    }
}
