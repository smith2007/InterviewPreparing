package fibonacci;

public class FibonacciGetterRecursive {

    public static void main(String[] args) {
        System.out.println(get(6));
    }

    static int get(int n) {
        if (n <= 1) {
            return n;
        }
        return get(n - 1) + get(n - 2);
    }
}
