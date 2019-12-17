package array;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 5};

        System.out.println(increasingTriplet(arr));

    }

    static boolean increasingTriplet(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            } else if (arr[i] < thirdMin) {
                thirdMin = arr[i];
            }
        }

        return min != Integer.MAX_VALUE && secondMin != Integer.MAX_VALUE && thirdMin != Integer.MAX_VALUE;

    }

}
