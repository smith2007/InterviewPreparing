package search;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {6, 1, 2};
        System.out.println(search(arr, 6));
    }


    static int search(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) {
            return -1;
        }

        int start = 0;
        int end = length - 1;

        //на этом этапе нам надо найти
        //индекс минимального элемента
        //как это сделать в ситуации когда массив сдвинут
        //берем два указателя
        //крутимся в цикле
        while (start < end) {
            //высчитываем средний элемент
            int mid = (start + end) / 2;
            int arrMid = arr[mid];
            int arrEnd = arr[end];
            //смотрим а в какую строну вообще сдвинут
            //массив
            //влево или вправо
            if (arrMid > arrEnd) {
                //если средний элемент больше чем конечный
                // то получается массив сдвинут вправо
                start = mid + 1;
            } else if (arrMid <= arrEnd) {
                //если же наоборот то массив сдвинут влево
                //и следующая итерация
                //там даст более точное значение
                end = mid;
            }
        }


        int rotated = start;
        start = 0;
        end = length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int midPlusRotated = mid + rotated;

            // вот это самый интересный фокус, как производить сдвиг
            //тот самый ротейт
            //включи сука голову
            //конечно же через деление по модулю
            //5%6=5
            //7%6=1
            int realindex = midPlusRotated % length;

            if (arr[realindex] == target) {
                return realindex;
            }
            if (arr[realindex] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;

    }
}
