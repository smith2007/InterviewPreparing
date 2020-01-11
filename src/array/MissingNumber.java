package array;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] nums) {
        int target = 0;
        for (int i = 0; i <= nums.length; i++) {
            target += i;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return target - sum;
    }
}
