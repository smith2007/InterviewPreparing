package sorting;

public class SortColorsMy {

    public static void main(String[] args) {

        int[] arr = {0, 2};

        sortColors(arr);

        for (int value : arr) {
            System.out.println(value);
        }
    }

    static void sortColors(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int start = 0;
        for (; start < arr.length; start++) {
            if (arr[start] != 0) {
                break;
            }
        }

        int end = arr.length - 1;

        for (; end >= 0; end--) {
            if (arr[end] != 2) {
                break;
            }
        }

        //наша задача тут выпихнуть двойки вперед
        while (start <= end) {

            if (arr[start] == 2) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                for (; end >= 0; end--) {
                    if (arr[end] != 2) {
                        break;
                    }
                }
            } else {
                start++;
            }


            if (start >= arr.length || end < 0) {
                break;
            }
        }


        start = 0;
        //наша задача тут выпихнуть двойки вперед
        while (start <= end) {

            if (arr[start] == 1) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                for (; end >= 0; end--) {
                    if (arr[end] != 1) {
                        break;
                    }
                }

            } else {
                start++;
            }


            if (start >= arr.length || end < 0) {
                break;
            }
        }

    }

}
