package array;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDaysEasy {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
        prisonAfterNDays(arr, 7);
    }


    static int[] prisonAfterNDays(int[] cells, int n) {

        if (cells.length == 0) {
            return cells;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (j >= 1 && j < cells.length - 1 && cells[j - 1] == cells[j + 1]) {
                    map.put(j, 1);

                } else {
                    map.put(j, 0);
                }
            }

            for (int j = 0; j < cells.length; j++) {
                Integer newVal = map.get(j);
                if (newVal != null) {
                    cells[j] = newVal;
                }

            }
            map.clear();
        }

        return cells;

    }


}
