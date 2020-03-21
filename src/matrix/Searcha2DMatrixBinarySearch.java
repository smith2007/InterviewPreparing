package matrix;

public class Searcha2DMatrixBinarySearch {

    public static void main(String[] args) {

        int[][] matr = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(searchMatrix(matr, 3));
    }


    /**
     * решаем за два бинарных поиска - первый бинарный поиск ищет подходящую строку
     * второй уже сам элемент в строке
     */
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int maxRowsCount = matrix.length;
        int maxColumnCount = matrix[0].length;

        // binary search #1: looking for the right row to search for the value
        int start = 0;
        int end = maxRowsCount;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][maxColumnCount - 1] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start == maxRowsCount) {
            return false;
        }
        //заодно проверим, может быть наш элемент крайний и можно сразу вернуть
        if (matrix[start][maxColumnCount - 1] == target) {
            return true;
        }

        //нашли строчку - ее зафиксируем - она будет константой
        int fixedRow = start;

        // ну и 2ой уже самый стандартный бинарный поиск в строке
        start = 0;
        end = maxColumnCount;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (matrix[fixedRow][mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start != maxColumnCount && matrix[fixedRow][start] == target;
    }
}
