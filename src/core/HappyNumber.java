package core;

public class HappyNumber {

    /**
     * 132.HappyNumber
     * <p>
     * https://leetcode.com/problems/happy-number/
     * <p>
     * дано число, проверить что данное число сводится к ЕДИНИЦЕ путем возведения разрядов этого числа в квадрат
     * <p>
     * Input: 19
     * Output: true
     * Explanation:
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     */


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /**
     * проблема решается путем решение проблемы цикла в массиве
     * она как ты помнишь решается через 2 указателя slow и fast
     * один из них ходит на два шага, второй на один шаг,
     * рано или поздно они должны встретится
     *
     * если есть цикл в массиве, то это значит что число НЕ ХЭППИ
     * то есть мы возвращаемся к той же самой цифре, соответсвенно каждый раз будем наступат на
     * те же самые грабли
     *
     * но если наш fast достиг 1 то это значит что мы достигли нашей цели
     *
     * гениальный алгоритм конечно
     */
    static boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    // вспомогательный метод
    //который берет число, раскладывает его на разряды
    //и возводит в степень

    static int getNext(int n) {
        int totalSum = 0;
        //как разложить в джаве число на разряды???
        //надо делить и получать остатки от деления он же mod оно же деление по модулю
        while (n > 0) {
            //первый шаг это поделить через остаток на 10
            int d = n % 10; //получаем остаток
            n = n / 10; //убираем один разряд из нашей цифры n
            totalSum += d * d; //возводим в квадрат и складываем
        }
        return totalSum;
    }

}
