package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSumListOfLists {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int sum = 0;

        System.out.println(find3Numbers(arr, sum));

    }

    static List<List<Integer>> find3Numbers(int[] arr, int sum) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (arr.length == 0) {
            return res;
        }

        Arrays.sort(arr);

        //первое значит - набиваем мапу из самих элементов с указанием их
        //индексов

        //таким образом мы избавимся от дубликатов кстати
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        //раскручиваем два цикла

        //по первому циклу будем искать первый элемент этого трио
        for (int i = 0; i < arr.length - 2; i++) {

            //по второму циклу будем как бы брать второй элемент
            for (int j = i + 1; j < arr.length - 1; j++) { //i+1 берем потому что хотим избежать дублей

                int first = arr[i];
                int second = arr[j];
                int third = sum - first - second;

                if (map.containsKey(third) && map.get(third) > j) {
                    res.add(List.of(arr[i], arr[j], third));
                    j = map.get(arr[j]);
                }

                i = map.get(arr[i]);
            }

        }

        return res;
    }


}
