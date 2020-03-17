package matrix;

public class KthSmallestElementinaSortedMatrixBinarySearch {

    public static void main(String[] args) {

        int[][] matrix = {{1, 5, 9},
                         {10, 11, 13},
                         {12, 13, 15}};

        System.out.println(kthSmallest(matrix, 8));
    }

    /**
     * тут ключевой смысл заключается в том что нам необходимо найти
     * элемент который позади себя имеет К элементов по значению
     * иными словами нам надо найти такой элемент Е - который вернет countElmsThatLessOrEqualMid(E) = k
     * ну или если с дубликатами то countElmsThatLessOrEqualMid(E) <= k
     *
     *  решаем это через бинарный поиск,а как решаем????
     *
     * наша матрица ведь не отсортирована, правильно, зато отсортированы строки в ней то есть как бы пласты в ней
     * 1, 5, 9
     * 10, 11, 13
     * 12, 13, 15
     *
     *ведь для бинарного поиска нужны границы left right и тд
     *
     * и так давай предположим что наши границы это нулевой элемент matrix[0][0] =1 и последний эл matrix[n][n]=15
     *
     * ну и постемепенно будем брать элементы по середине, искать тот самый элемент который встречается k раз первым
     *
     * для этого считаем миддл и ищем сколько элементов меньше либо равно нашему мидлу???
     *
     * меньше чем k ????? если меньше то надо взять миддл побольше то есть сместить границу вправо
     * а если больше чем k то надо сместить границу левеее
     *
     * ну и крутимся в цикле пока наши индексы не встретятся
     */
    static int kthSmallest(int[][] matrix, int k) {
        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int n = matrix.length;
        //и так давай предположим что наши границы это нулевой элемент matrix[0][0] =1 и последний эл matrix[n][n]=15
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            //ну и постемепенно будем брать элементы по середине, искать тот самый элемент который встречается k раз первым
            int mid = left + (right - left) / 2;

            // для этого считаем миддл и ищем сколько элементов меньше либо равно нашему мидлу???
            int count = countElmsThatLessOrEqualMid(matrix, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // этот метод возвращает кол-во элементов которые <= mid
    static int countElmsThatLessOrEqualMid(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length - 1;
        for (int[] arr : matrix) {
            while (j >= 0 && arr[j] > mid) {
                j--;
            }
            count += j + 1;
        }

        return count;
    }
}
