import java.util.stream.IntStream;

public class QuickSort {

    public static void sort(int[] arr) {

        int begin = 0;
        int end = arr.length - 1;

        sort(arr, begin, end);
    }

    private static void sort(int[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }

        int partitionIndex = getPartitionIndex(arr, begin, end);

        sort(arr, begin, partitionIndex - 1);
        sort(arr, partitionIndex + 1, end);

    }

    // этот метод выбирает опорный элемент
    // и делает перестановки - все что меньше слева опорного
    // все что справа - больше опорного
    // далее возвращает новый индекс опорного

    private static int getPartitionIndex(int[] arr, int begin, int end) {
        int indexOfPivot = end;
        int pivot = arr[indexOfPivot];

        //мы будем финальным этапом двигать опорный элемент на новое место,
        //но как вычислить новое место, но какое место являеется новым?
        //как понять куда двигать?
        //для этого создадим переменную middleIndex,
        //которая будет являтся как бы новым виртуальным индексом
        //и будем двигать ее вместе с каждой перестановкой
        //а в конце мы проинкрементим этот индекс,
        // и свопнем c элементом под индексом пивота
        // свопнем элемент котороый находится на позиции middleIndex
        //то есть эта переменная как бы индекс середины
        int middleIndex = begin - 1;

        for (int i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                middleIndex++;
                int temp = arr[middleIndex];
                arr[middleIndex] = arr[i];
                arr[i] = temp;
            }
        }

        middleIndex++;
        int temp = arr[middleIndex];
        arr[middleIndex] = arr[indexOfPivot];
        arr[indexOfPivot] = temp;

        return middleIndex;
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 2, 4, 0, 9, 1, 21, 12, 43, 78, 99, 111, 3};
        sort(arr);
        IntStream.of(arr).boxed().forEach(System.out::println);
    }

}
