package bit_manipulation;

public class ReverseBits {

    public static void main(String[] args) {

        System.out.println(rev(5));

    }


    static int rev(int n){
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    /**
     *
     * Input:     00000010100101000001111010011100
     * Output: 00111001011110000010100101000000
     * нам надо перевернуть как бы - то есть посмотри внимательно - сделать в обратную сторону
     *
     * на на входе у нас десятичное число и на выходе нужно десятичное
     *
     * Integer.reverse(n) - самый простой способ
     *
     *
     * окей для начала давай возьмем массив интов что бы представить наш инт
     */
    static int reverseBits(int n) {
        int[] binary = new int[32];

        int i = 0;

        //вот тут заполняем наш массив нулями и единицами
        while (n > 0) {
            int modRes = n % 2;
            binary[i] = modRes;
            n /= 2;
            i++;
        }

        //далее идем с конца
        //и делаем переворот - набивая десятичное число
        int base = 1;
        int decimal = 0;
        for (int j = binary.length - 1; j >= 0; j--) {
            if (binary[j] == 1) {
                decimal += base;
            }
            base *= 2;
        }
        return decimal;
    }
}
