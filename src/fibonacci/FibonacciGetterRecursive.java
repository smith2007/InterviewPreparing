package fibonacci;

public class FibonacciGetterRecursive {

    static int get(int n) {
        if (n <= 1) {
            return n;
        }
        return get(n - 1) + get(n - 2);
    }
}
