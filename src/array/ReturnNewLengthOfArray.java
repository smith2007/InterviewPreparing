package array;

public class ReturnNewLengthOfArray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int val = 3;
        System.out.println(remove(arr, val));
    }

    static int remove(int[] arr, int val) {
        int newCount = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != val) {
                arr[newCount] = arr[j];
                newCount++;
            }
        }
        return newCount;
    }
}
