package bfs;

import java.util.*;

public class WordLadder {

    /**
     *
     * https://leetcode.com/problems/word-ladder/
     *
     * На входе у нас дано два слова beginWord и endWord а так же словарь - найди длинну кратчайшей трансформации
     * последовательности начиная с beginWord до endWord
     * переводим из beginWord в endWord
     *  - только одна буква может меняться за один раз
     *  - каждое трансформированное слово обязано присутсвовать в словаре, при этом beginWord - это не
     *  трансформированное слово
     *
     * верни 0 если нет последовательностей которые возможно трансформировать
     * все слова имеют одинаковую длинну
     * нет дубликатов в словаре
     *
     * Example 1:
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * подход первый
     *
     * интересный алгоритм, решается через BFS c очередью, на самом деле этот вариант как бы очень логичен, суть в
     * том что мы создаем очередь, заряжаем начальное слово а потом извлекаем в цикле,
     * тупо заменяем по букве и проверяем что слово содержится в словаре
     *
     * так же цикл вайл у нас будет фиксировать level, а level, как ты помнишь фиксируется через двойной вайл с сайзом
     * так же очень важно не делать двойную работу и не закрутится в бесконечном цикле - для этого необходимо
     * сохранять где-то уже посещенные слова, для этого создаем дополнительный сет  Set<String> visited = new
     * HashSet<>();
     */

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
