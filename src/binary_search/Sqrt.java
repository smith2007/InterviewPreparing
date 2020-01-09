package binary_search;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(25));
    }

    /**
     * как же данная задача решается бинарным поиском
     */
    static int sqrt(int x) {
        if (x < 2) {
            //если элемент меньше 2ух - 1 или 0 нечего тужится - сразу возвращаем
            return x;
        }

        long midKvadrat = 0;
        int mid = 0;
        int start = 2;
        int end = x / 2;

        /**
         * наша идея состоит в том что бы динамически
         * подбором найти такой элемент который в квадрате дает наш Х на входе
         *
         * как это сделать??
         * ну как как давай стрелять бинарным поиском!
         *
         * и брать миддл -  возводить его в квадрат,
         * смотрим - попали ??
         * или больше чем надо?
         * или меньше чем надо?
         *
         * вот если больше чем надо, например мы ищем корень из 25
         * start = 2, end = x/2 = 12 -> mid = 7 -> mid^2 = 49
         * значит нет mid == 7  нам не подходит, надо смещать правую границу end - так что бы
         * mid был меньше
         *
         * соотв 2ая итерация start = 2 , end = 6, mid = 4, mid^2 = 16 - мало!
         * смещаем левую границу - start!
         *
         * 3 итерация start = 5, end = 6 и тд
         * гениальный алгоритм
         */
        while (start <= end) {
            //стандартно считаем миддл
            mid = start + (end - start) / 2;

            //затем высчитываем квадрат
            midKvadrat = (long) mid * mid;

            //и все, пытаемся попасть в наш таргет число - х
            if (midKvadrat == x){
                return mid;
            } else if (midKvadrat > x) {
                end = mid - 1;
            } else if (midKvadrat < x) {
                start = mid + 1;
            }
        }
        return end;
    }
}



