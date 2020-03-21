package trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //ну и все пробегаем по каждой букве в матрице пытаемся от нее плясать
                dive(board, i, j, root, res);
            }
        }
        return res;
    }


    public void dive(char[][] board, int i, int j, TrieNode trieNode, List<String> res) {
        char currLetter = board[i][j];
        if (currLetter == '#' || trieNode.next[currLetter - 'a'] == null) {
            //если такой буквы нет или она уже ранее была посещена - выходим
            return;
        }
        trieNode = trieNode.next[currLetter - 'a'];
        if (trieNode.word != null) {   // found one
            res.add(trieNode.word);
            trieNode.word = null;     // de-duplicate
        }

        //раскрашиваем уже посещенные ноды
        board[i][j] = '#';

        //идем в 4 направлениях
        if (i > 0){
            dive(board, i - 1, j, trieNode, res);
        }
        if (j > 0){
            dive(board, i, j - 1, trieNode, res);
        }
        if (i < board.length - 1){
            dive(board, i + 1, j, trieNode, res);
        }
        if (j < board[0].length - 1){
            dive(board, i, j + 1, trieNode, res);
        }
        //перекрашиваем обратно
        board[i][j] = currLetter;
    }

    //билдим префиксное дерево
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {

            //каждое слово у нас будет идти с рутовой ноы
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (curr.next[i] == null){
                    curr.next[i] = new TrieNode();
                }
                curr = curr.next[i];
            }

            curr.word = word;
        }
        return root;
    }

    //описываем трие ноду
    //в простом варианте она состоит из массива таких же Trie нод
    //и самого корневого слова в случае если эта нода является словообразубщей
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
