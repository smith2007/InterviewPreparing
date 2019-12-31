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
    static int reverseBits(int n) {
        int[] binary = new int[32];

        int i = 0;

        while (n > 0) {
            int modRes = n % 2;
            binary[i] = modRes;
            n /= 2;
            i++;
        }

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
