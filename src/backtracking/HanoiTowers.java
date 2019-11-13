package backtracking;

public class HanoiTowers {

    public static void main(String[] args) {

        hanoi(2, 'A', 'B', 'C');
    }

    static void hanoi(int n, char from, char to, char cache) {
        if (n == 1) {
            System.out.println("Move 1 disk from " + from + " to " + to);
        } else {
            hanoi(n - 1, from, cache, to);
            System.out.println("Move " + n + " disk from " + from + " to " + to);
            hanoi(n - 1, cache, to, from);
        }

    }
}
