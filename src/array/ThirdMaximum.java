package array;

public class ThirdMaximum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 5, 3, 5};

        System.out.println(thirdMax(arr));
    }

    static int thirdMax(int[] arr) {

        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (int elm : arr) {
            if (first == null || elm >= first) {
                if (first != null && elm == first) {
                    continue;
                }
                third = second;
                second = first;
                first = elm;
            } else if (second == null || elm >= second) {
                if (second!=null && elm == second) {
                    continue;
                }
                third = second;
                second = elm;
            } else if (third == null || elm >= third) {
                third = elm;
            }
        }


        if (third != null) {
            return third;
        } else {
            return first;
        }
    }
}
