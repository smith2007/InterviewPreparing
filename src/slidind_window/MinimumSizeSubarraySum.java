package slidind_window;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int[] arr = {1, 4, 4};
        int target = 4;

        System.out.println(minSubArrayLen(arr, target));
    }

    static int minSubArrayLen(int[] arr, int target) {

        if (arr.length == 0) {
            return 0;
        }

        int i = 0, j = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (j < arr.length) {
            sum += arr[j];
            j++;
            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= arr[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
