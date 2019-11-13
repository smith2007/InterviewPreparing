package search;

public class FindTheDuplicateNumberMarker {

    /**
     * казалось бы простая задача - дан массив не отсортированный
     * там все элементы уникальны кроме одного - найти задублированный элемент массив
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 1};
        System.out.println(findDuplicate(arr));
    }

    static int findDuplicate(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[j] < 0) { // мы маркируем значения на индексах
                return j; // если мы встретили значение под индексом уже промаркированное
            }//это значит что мы уже встречали такой элемент,
            // то биш такое значение которое нас привело в этот индекс

            arr[j] = arr[j] * -1; // помечаем его

            //какой будет следующий индекс?
            j = Math.abs(arr[j]); // 1
        }

        return -1;
    }
}
