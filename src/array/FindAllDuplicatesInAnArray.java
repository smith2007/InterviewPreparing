package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {


    /**
     *
     121.FindAllDuplicatesInAnArray.
     https://leetcode.com/problems/find-all-duplicates-in-an-array/

     дан массив чисел, числа от 1 до n, вернуть все задублированные элементы в нем

     Input:
     [4,3,2,7,8,2,3,1]
     Output:
     [2,3]

     опять как и в задаче про первый дубликат 87.FindTheDuplicateNumber - мы рассматриваем задачу как закольцованный
     линкед лист (потому что максимальное число n), соответсвенно решение в том что мы маркируем
     наш итый элемент массива минусом, это значит мы это число уже посетили
     *
     */
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }

    static List<Integer> findDuplicates(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();

        if (arr.length == 0) {
            return res;
        }
        // раскручиваем цикл
        for (int i = 0; i < arr.length; i++) {

            //берем текущий элемент
            int elm = arr[i];

            int elmFromElm = arr[Math.abs(elm) - 1];

            if (elmFromElm < 0) {
                res.add(Math.abs(elm));
            } else {
                arr[Math.abs(elm) - 1] = elmFromElm * -1;
            }

        }

        return res;

    }
}
