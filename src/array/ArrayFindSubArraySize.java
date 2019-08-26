package array;

public class ArrayFindSubArraySize {


    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 6, 7, 3, 0, 9, 1};
        // длинна 9


        System.out.println(getSubArraySize(arr, 0, 8)); // 9

        System.out.println(getSubArraySize(arr, 1, 8)); //8

        System.out.println(getSubArraySize(arr, 3, 5)); //3

        System.out.println(getSubArraySize(arr, 2, 3)); //2

        System.out.println(getSubArraySize(arr, 2, 2)); //1

        System.out.println(getSubArraySize(arr, 8, 9)); //2


    }

    static int getSubArraySize(int[] arr, int start, int end) {

        if (start == 0) {
            return (start + 1) + end;
        } else {
            return end - (start - 1);
        }
    }
}
