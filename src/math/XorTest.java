package math;

public class XorTest {

    public static void main(String[] args) {
        int res = 1 ^ 2;
        System.out.println(res); // 3

        int res1 = 2 ^ 2;
        System.out.println(res1); // 0

        int res2 = -1 ^ 2;
        System.out.println(res2); // -3

        int res3 = -1 ^ -2;
        System.out.println(res3); // 1

        int res4 = 1 ^ -2;
        System.out.println(res4); // -1
    }
}
