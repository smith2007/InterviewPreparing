package array;

public class ArrayAllElementsDuplicatedExceptOneFindThisOne {


    /**
     * 30.Дан массив чисел, в этом массиве каждый элемент продублирован кроме одного, необходимо за логарифмическое время и константую память найти этот единичный элемент
     * <p>
     * <p>
     * если мы говорим о логарифмической скорости то тут однозначно надо брать в расчет бинарный поиск, модифицированный бинарный поиск, так же итерационным подходом
     * <p>
     * короче, тут надо делать так, берем цикл вайл, в нем крутимся до тех пор пока наши указатели на начало и конец не встретятся
     * <p>
     * берем миддл элемент, смотрим соседей этого мидла, если он один и никого вокруг нет то это и есть наш элемент,
     * <p>
     * если его брат стоит слева от него, смотрим длинну подмассива, нам надо понять, куда нам мазафака идти бинарным поиском влево или вправо
     * <p>
     * если длинна левого подмассива НЕ четная тогда и идем бинарным поиском влево
     * <p>
     * если длинная подмассива ЧЕТНАЯ тогда там все дубли хранятся, идем бинарным поиском вправо
     * <p>
     * <p>
     * сложность по времени: О(log n)
     * сложность по памяти: О(1)
     */
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};

        System.out.println(find(arr));    }

    static int find(int[] arr){
        return util(arr,0,arr.length-1);
    }

    static int util(int[] arr, int start, int end) {

        if (arr.length == 1) {
            return arr[0];
        }

        if (start == end){
            return arr[start];
        }

        int mid = start + (end - start) / 2;


        boolean isOddLength = (mid - start) % 2 == 1;

        if (isOddLength) {
            if (arr[mid] == arr[mid - 1]) {
                return util(arr, mid + 1, end);
            }
            return util(arr, start, mid - 1);
        }

        if (arr[mid] == arr[mid - 1]) {
            return util(arr, start, mid);
        }
        return util(arr, mid, end);
    }


}