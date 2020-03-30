package matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];

        List<List<Integer>> res = new ArrayList<>();

        //птыаемся пойти с двух конциа слева и справа
        for (int i = 0; i < matrix.length; i++) {
            dfsMarking(i, 0, Integer.MIN_VALUE, pacific, matrix);
            dfsMarking(i, matrix[0].length - 1, Integer.MIN_VALUE, atlantic, matrix);

        }

        //со потолка и с пола
        for (int j = 0; j < matrix[0].length; j++) {
            dfsMarking(0, j, Integer.MIN_VALUE, pacific, matrix);
            dfsMarking(matrix.length - 1, j, Integer.MIN_VALUE, atlantic, matrix);
        }

        //находим общие элементы которые достигаеме со всех сторон
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    LinkedList<Integer> point = new LinkedList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }

    //запускаем дфс и добавляем все ячейки которые достигаются с определенного океана
    //ocean - он же массив visited
    private static void dfsMarking(int i, int j, int prevVal, int[][] ocean, int[][] matrix) {

        //out of bounds
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1) {
            return;
        }

        //already visited
        if (ocean[i][j] == 1) {
            return;
        }

        //если текущая ячейка может быть продолжением чейна - помечаем ее как результатативную
        if (matrix[i][j] >= prevVal) {
            ocean[i][j] = 1;

            //и смотрим ее соседей
            dfsMarking(i + 1, j, matrix[i][j], ocean, matrix);
            dfsMarking(i - 1, j, matrix[i][j], ocean, matrix);
            dfsMarking(i, j + 1, matrix[i][j], ocean, matrix);
            dfsMarking(i, j - 1, matrix[i][j], ocean, matrix);
        }
    }
}
