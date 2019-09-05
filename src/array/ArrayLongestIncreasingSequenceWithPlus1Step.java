package array;

import java.util.HashMap;

public class ArrayLongestIncreasingSequenceWithPlus1Step {

    /**
     *
     задача с массивом, есть массив в нем числа  arr = {100, 101, 10, 1, 15, 2, 3, 4, 5}

     необходимо найти сумму всех элементов возрастающей прогресси с шагом в единицу

     ответ будет 1 2 3 4 5 = длинна равна 5

     за линейное время

     решать будем через мапу и переменную мах, мапа будет содержать в качестве ключа последний элемент цепочка, а в качестве значения будет длинна цепочки

     бежим по массиву, фиксируем все цепочки, апдейтим максимум если надо

     в конце возвращаем максимум
     */
    public static void main(String[] args) {
        int[] arr = {100, 101, 10, 1, 15, 2, 3, 4, 5};

        System.out.println(find(arr));
    }


    static int find(int[] arr) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elm : arr) {
            Integer elmCount = map.get(elm - 1);
            if (elmCount == null) {
                map.put(elm, 1);
                if (max == 0) {
                    max = 1;
                }
            } else {
                map.remove(elm - 1);
                map.put(elm, elmCount + 1);
                if (elmCount + 1 > max) {
                    max = elmCount + 1;
                }
            }
        }

        return max;
    }
}
