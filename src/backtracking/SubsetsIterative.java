package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsIterative {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> result = sets(arr);

        for (List<Integer> list : result) {
            for (Integer elm : list) {
                System.out.print(" " + elm);
            }
            System.out.println();
        }


    }

    static List<List<Integer>> sets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); //сразу инициализируем пустым массивом ч
                                        // то бы дальше было от чего отталкиватся
        for (int i = 0; i < arr.length; i++) {
            int size = result.size(); // зафиксируем размер результируеющего массива,
                                        // он понадобится в дальнейшем что бы взять
                                        //  все существующие элементы которые будем добавлять в цепочки

            for (int j = 0; j < size; j++) {
                List<Integer> accum = new ArrayList<>();
                accum.addAll(result.get(j));
                accum.add(arr[i]);
                result.add(accum);
            }

        }
        return result;
    }
}
