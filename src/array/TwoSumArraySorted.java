package array;

public class TwoSumArraySorted {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 4};
        int summ = 8;

        print(arr1, summ);
        // 4 4

        /**
         * берем первый и последний - 1+4 = 5 мало, двигаем левую часть - 2+4 = 6 - мало двигаем  левую часть 4+4 норм
         */

/*

        int[] arr2 = {1, 2, 3, 4, 9};
        int summ2 = 9;
        print(arr2, summ2);

        // Exception
*/


        int[] arr3 = {1, 2, 3, 4, 9};
        int summ3 = 12;
        print(arr3, summ3);
        // 3 4

        /**
         * берем первый и последний, складываем - получилось больше или меньше, например меньше, двигаем левую часть,
         * дальше смотрим получилось больше или меньше, например меньше - опять двигаем левую часть
         * - хоп а на третьей итерации равно
         */


        int[] arr4 = {1, 2, 3, 4, 9, 15};
        int summ4 = 7;

        print(arr4, summ4);

        /**
         * 1 - 15 = 16 много; 1 + 9 = 10 много; 2+9=11 много; 2+4=6 - мало; 3+4 =7 норм
         */


    }

    /**
     * самый тупой - это конечно взять и носится по каждому элементу и сравнивать с каждым
     * сложность квадратичная
     * <p>
     * по умнее
     */
    static void print(int[] arr, int summ) {
        int i = 0;
        int j = arr.length - 1;

        while (i != j) {
            int localSumm = arr[i] + arr[j];
            if (localSumm == summ) {
                System.out.println("Pair is " + arr[i] + " " + arr[j]);
                return;
            } else if (localSumm < summ) {
                i++;
            } else if (localSumm > summ) {
                j--;
            }
        }

        throw new RuntimeException("There is no pair in array for summ = " + summ);

    }

}
