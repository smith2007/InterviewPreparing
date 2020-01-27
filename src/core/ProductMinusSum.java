package core;

public class ProductMinusSum {

    public static void main(String[] args) {
        System.out.println(s(80));
    }

    static int s(int n) {

        int prod = 1;
        int sum = 0;

        while (n > 9) {
            int prod1 = n % 10;
            prod *= prod1;
            sum += prod1;
            n = n / 10;
        }

        prod *= n;
        sum += n;


        return prod - sum;
    }
}
