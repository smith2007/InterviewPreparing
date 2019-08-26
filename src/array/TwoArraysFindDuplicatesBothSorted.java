package array;

public class TwoArraysFindDuplicatesBothSorted {

    public static void main(String[] args) {
        int[] first = {3, 5, 6, 8, 9, 122};
        int[] second = {1, 2, 4, 6, 7, 10, 12, 14, 122};

        find(first, second);
        //duplicates are (is) 6 122

    }

    // complexity O(n)
    private static void find(int[] first, int[] second) {
        String s = "";
        for (int i = 0, j = 0; i < first.length && j < second.length; ) {
            int elm1 = first[i];
            int elm2 = second[j];

            if (elm1 == elm2) {
                s = s + " " + elm1;
                i++;
                j++;
            } else if (elm1 > elm2) {
                j++;
            } else if (elm2 > elm1) {
                i++;
            }
        }

        if (s.isEmpty()) {
            System.out.println("There are no duplicates");
        } else {
            System.out.println("Duplicates are " + s);
        }
    }
}
