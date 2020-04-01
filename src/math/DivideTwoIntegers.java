package math;

import java.util.ArrayList;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers ins = new DivideTwoIntegers();
        System.out.println(ins.divide(256,8));
    }

    private static int HALF_INT_MIN = -1073741824;


    public int divide(int dividend, int divisor) {

        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //мы переводим оба числа в отрицательные если они уже не отрицательные
        //так же нам надо посчитать сколько у нас минусов - то есть все ли отрицательные числа
        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        //было например 256 и 8 => -256 и -8
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        //при кейсе с 256 и 8 они будут запонены как
        // -8, -16, -32, -64, -128, -256
        ArrayList<Integer> doubles = new ArrayList<>();
        // -1, -2, -4, -16, -32
        ArrayList<Integer> powersOfTwo = new ArrayList<>();

        //делаем два списка один - это как бы умножение нашего делителя на 2
        //второй список это степени двойки нашего делителя

        /* Nothing too exciting here, we're just making a list of doubles of 1 and
         * the divisor. This is pretty much the same as Approach 2, except we're
         * actually storing the values this time. */
        int powerOfTwo = -1;
        while (divisor >= dividend) {
            doubles.add(divisor);
            powersOfTwo.add(powerOfTwo);
            // Prevent needless overflows from occurring...
            if (divisor < HALF_INT_MIN) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }

        //divisor = -512
        //powerOfTwo = -64

        //начинаем набивать резалт
        int result = 0;
        /* Go from largest double to smallest, checking if the current double fits.
         * into the remainder of the dividend. */
        //идем от наибольшего элемента дабл к наименьшему
        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (doubles.get(i) >= dividend) {
                // If it does fit, add the current powerOfTwo to the result.
                result += powersOfTwo.get(i);
                // Update dividend to take into account the bit we've now removed.
                dividend -= doubles.get(i);
            }
        }

        //если там изаначально был один минус
        //то оставляем наш элемент отрицательным
        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -result;
        }
        return result;
    }
}
