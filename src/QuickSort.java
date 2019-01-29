import java.util.stream.IntStream;

public class QuickSort {

    private static void sort(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        sort(arr, begin, end);
    }

    private static void sort(int[] arr, int begin, int end) {

        if (begin > end) {
            return;
        }

        int pivotIndex = findPivotAndPutAround(arr, begin, end);
        sort(arr, begin, pivotIndex - 1);
        sort(arr, pivotIndex + 1, end);
    }

    // этот метод выбирает опорный элемент
    // и делает перестановки - все что меньше слева опорного
    // все что справа - больше опорного
    // далее возвращает новый индекс опорного
    // данный метод и код работает только тогда
    // когда в качестве pivot мы берем ПОСЛЕДНИЙ элемент
    // если брать в качестве любой другой эта реализация работать не будет

    private static int findPivotAndPutAround(int[] arr, int begin, int end) {
        int pivot = arr[end];

        //мы будем финальным этапом двигать опорный элемент на новое место,
        //но как вычислить новое место, но какое место являеется новым?
        //как понять куда двигать?
        //для этого создадим переменную newPivotIndex,
        //которая будет являтся как бы новым виртуальным индексом
        //и будем двигать ее вместе с каждой перестановкой
        //а в конце мы проинкрементим этот индекс,
        //и свопнем c элементом под индексом пивота
        // свопнем элемент котороый находится на позиции newPivotIndex
        //то есть эта переменная как бы индекс середины

        int newPivotIndex = begin - 1;

        for (int i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                newPivotIndex++;
                int temp = arr[newPivotIndex];
                arr[newPivotIndex] = arr[i];
                arr[i] = temp;
            }
        }

        newPivotIndex++;
        int temp = arr[newPivotIndex];
        arr[newPivotIndex] = arr[end];
        arr[end] = temp;

        return newPivotIndex;
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 2, 4, 0, 9, 1, 21, 12, 43, 78, 99, 111, 3};
        sort(arr);
        IntStream.of(arr).boxed().forEach(System.out::println);


        int[] arr1 = {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};
        sort(arr1);
        IntStream.of(arr1).boxed().forEach(System.out::println);
    }

}
