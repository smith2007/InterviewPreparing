package string;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance2 {

    public static void main(String[] args) {

    }


    public int shortestDistance(String[] arr, String word1, String word2) {

        if (arr.length < 2 || word1 == null || word2 == null) {
            return 0;
        }

        List<Integer> ind1 = new ArrayList<>();
        List<Integer> ind2 = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word1)) {
                ind1.add(i);
            } else if (arr[i].equals(word2)) {
                ind2.add(i);
            }
        }

        int i = 0;
        int j = 0;

        int res = Integer.MAX_VALUE;

        while (true) {
            res = Math.min(res, Math.abs(ind1.get(i) - ind2.get(j)));
            if (i < ind1.size() - 1 && j < ind2.size() - 1) {
                if (ind1.get(i + 1) < ind2.get(j + 1)) {
                    i++;
                } else {
                    j++;
                }
            } else if (i < ind1.size() - 1) {
                i++;
            } else if (j < ind2.size() - 1) {
                j++;
            } else {
                break;
            }

        }
        return res;
    }
}
