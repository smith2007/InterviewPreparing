package array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 1, 0, 1, 2, 1, 0, 1};

        System.out.println(find(arr));
    }

    static int find(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int water = 0;

        int localMaxi = 0;
        int localMaxj = 0;

        while (i != j) {
            if (arr[i] > localMaxi) {
                localMaxi = arr[i];
            }

            if (arr[j] > localMaxj) {
                localMaxj = arr[j];
            }

            if (arr[i] < arr[j]) {
                i++;
                int localWater = localMaxi - arr[i];
                if (localWater > 0) {
                    water += localWater;
                }
            } else {
                j--;
                int localWater = localMaxj - arr[j];
                if (localWater > 0) {
                    water += localWater;
                }
            }
        }
        return water;

    }
}
