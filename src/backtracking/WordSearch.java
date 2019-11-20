package backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    public static void main(String[] args) {


 /*       char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
*/

        char[][] arr = {
                {'A'}
        };

        System.out.println(exist(arr, "AB"));
    }

    static boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.isEmpty()) {
            return false;
        }

        List<List<Integer>> coord = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    coord.add(list);
                }
            }
        }

        if (coord.isEmpty()) {
            return false;
        }
        for (List<Integer> oneCoord : coord) {
            if (backtrack(board, word, oneCoord.get(0), oneCoord.get(1), 0)) {
                return true;
            }
        }
        return false;
    }

    static boolean backtrack(char[][] board, String word, int row, int column, int currIndex) {

        if (column > board[0].length - 1 || row > board.length - 1 || currIndex > word.length() - 1 ||
                column < 0 || row < 0) {
            return false;
        }

        char charAt = word.charAt(currIndex);

        if (charAt != board[row][column]) {
            return false;
        } else if (currIndex == word.length() - 1) {
            return true;
        } else {
            char currSumb = board[row][column];

            board[row][column] = '*';

            boolean result = backtrack(board, word, row, column + 1, currIndex + 1) ||
                    backtrack(board, word, row, column - 1, currIndex + 1) ||
                    backtrack(board, word, row + 1, column, currIndex + 1) ||
                    backtrack(board, word, row - 1, column, currIndex + 1);

            board[row][column] = currSumb;

            return result;
        }


    }

}
