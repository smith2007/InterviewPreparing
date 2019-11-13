package fibonacci;

public class FibonacciGetterIterative {

    public static void main(String[] args) {
        System.out.println(fibb(0));
        //0
        System.out.println(fibb(2));
        //1
        System.out.println(fibb(50));
        //34
    }

    static int fibb(int n) {
        int nMinus2 = 0;
        int nMinus1 = 1;
        if (n == 0) {
            return nMinus2;
        }
        if (n == 1) {
            return nMinus1;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = nMinus2 + nMinus1;
            int temp = nMinus1;
            nMinus1 = result;
            nMinus2 = temp;
        }
        return result;
    }
}
