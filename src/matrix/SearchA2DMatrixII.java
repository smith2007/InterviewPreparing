package matrix;

public class SearchA2DMatrixII {

    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] arr : matrix) {
            if (arr[0] == target || arr[arr.length - 1] == target) {
                return true;
            } else if (arr[0] < target && arr[arr.length - 1] > target) {
                boolean res = binarySearch(arr, target);
                if (res) {
                    return true;
                }
            }
        }
        return false;

    }


    static boolean binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
