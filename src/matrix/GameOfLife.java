package matrix;

import java.util.Arrays;

public class GameOfLife {


    /**
     * 176.GameOfLife
     * <p>
     * https://leetcode.com/problems/game-of-life/
     * <p>
     * <p>
     * согласно статье в википедии гейм оф лайф так же известная как просто Лайф - это клеточный автомат, разработанный британским математиком Джоном Хортоном Конвеем в 1970 году.
     * смысл вот в чем, дана доска размера m x n где каждая клетка имеет значение 0 или 1 - 0 означает мертвый, 1 живой
     * каждая ячейка соединена с 8 соседями (горизонталь, вертикаль, диагональ) используя следующие 4 правила:
     * <p>
     * 1- каждая живая ячейка (1) с менее чем 2умя живыми соседями умирает - изза under population
     * 2-каждая живая ячейка с 2 или 3 живыми соседями живет до следующего поколения
     * 3-каждая живая ячейка с более 3 живыми соседями умирает изза over population
     * 4-каждая мертвая ячейка с точно 3 живыми соседями вновь оживает
     * задача состоит в том что бы написаьб алгоритм который высчитывает следующее состояни на этой доске согласно описанным правилам
     * <p>
     * Input:
     * [
     *   [0,1,0],
     *   [0,0,1],
     *   [1,1,1],
     *   [0,0,0]
     * ]
     * Output:
     * [
     *   [0,0,0],
     *   [1,0,1],
     *   [0,1,1],
     *   [0,1,0]
     * ]
     */

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    static void gameOfLife(int[][] board) {

        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int curr = board[i][j];

                int numberOfAlive = 0;
                if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1)) {
                    numberOfAlive++;
                }
                if (i + 1 < board.length && (board[i + 1][j] == 1 || board[i + 1][j] == -1)) {
                    numberOfAlive++;
                }
                if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1)) {
                    numberOfAlive++;
                }
                if (j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == -1)) {
                    numberOfAlive++;
                }

                int leftUpi = i - 1;
                int leftUpj = j - 1;

                if (leftUpi >= 0 && leftUpj >= 0 && (board[leftUpi][leftUpj] == 1 || board[leftUpi][leftUpj] == -1)) {
                    numberOfAlive++;
                }

                int leftDowni = i + 1;
                int leftDownj = j - 1;

                if (leftDowni < board.length && leftDownj >= 0 && (board[leftDowni][leftDownj] == 1 || board[leftDowni][leftDownj] == -1)) {
                    numberOfAlive++;
                }


                int rightUpi = i + 1;
                int rightUpj = j + 1;

                if (rightUpi < board.length && rightUpj < board[0].length && (board[rightUpi][rightUpj] == 1 || board[rightUpi][rightUpj] == -1)) {
                    numberOfAlive++;
                }

                int rightDowni = i - 1;
                int rightDownj = j + 1;

                if (rightDowni >= 0 && rightDownj < board[0].length && (board[rightDowni][rightDownj] == 1 || board[rightDowni][rightDownj] == -1)) {
                    numberOfAlive++;
                }

                if (curr == 1) {
                    if (numberOfAlive < 2 || numberOfAlive > 3) {
                        board[i][j] = -1;

                    }
                } else {
                    if (numberOfAlive == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
