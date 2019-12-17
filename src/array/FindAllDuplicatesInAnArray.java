package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
    }

    static List<Integer> findDuplicates(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();

        if (arr.length == 0) {
            return res;
        }

        for (int i = 0; i < arr.length; i++) {

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
