import java.util.stream.IntStream;

public class ArrayMoveZerosToTheLeftSafeOrder {

    /**
     * ну что есть массив чисел в них рандомно разбросаны нули
     * надо сохранив порядок переместить все нули в конец
     * время линейное память дополнительую использовать нельзя
     */
    public static void main(String[] args) {
        int[] arr = {4, 0, 1, 2, 0, 2, 6, 0};
        move(arr);
        IntStream.of(arr).forEach(System.out::println);
        //4 1 2 2 6 0 0 0
    }

    /**
     * в решении я для наглядности первый раз за первый проход нахожу адрес первого нуля
     */
    static int[] move(int[] arr) {
        int zeroIndex = -1;

        // вот тут индекс первого нуля
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                zeroIndex = j;
                break;
            }
        }

        // заодно и обрабатываем частный случай когда нулей нет
        if (zeroIndex == -1) {
            return arr;
        }

        //или когда ноль и так стоит последним элементом
        if (zeroIndex == arr.length - 1) {
            return arr;
        }

        //далее раскручиваем цикл с нашего индекса найденого выше
        for (int i = zeroIndex + 1; i < arr.length; i++) {

            // как только нашли элемент свопаем
            if (arr[i] != 0) {
                int temp = arr[zeroIndex];
                arr[zeroIndex] = arr[i];
                arr[i] = temp;

                // и самое важное понимаем как поступить дальше с индексом
                if (arr[zeroIndex + 1] == 0) {
                    // если далее стоит два нуля то двигать надо очень аккуратно
                    zeroIndex = zeroIndex + 1;
                } else {
                    zeroIndex = i;
                }
            }

        }
        return arr;

    }
}
