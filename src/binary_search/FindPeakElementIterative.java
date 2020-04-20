package binary_search;

public class FindPeakElementIterative {

    /**
     *
     здесь надо решать через бинарный поиск причем хитрый бинарный поиск,
     в чем же его хитрость, во первых, мы так же берем два указателя на начало и на конец,
     крутимся в цикле считаем миддл через стандартную формулу
     хитрость в том как мы апдейтим индексы,
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2, 1};
        System.out.println(find(nums));
    }

    static int find(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        if (arr.length == 2) {
            return arr[0] > arr[1] ? 0 : 1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
