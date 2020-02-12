package math;

public class PowerOfTwo {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(8));
    }

    static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while (true) {
            if (n == 1) {
                return true;
            }

            int ostatok = n % 2;

            if (ostatok != 0) {
                return false;
            }

            n /= 2;
        }
    }

}
