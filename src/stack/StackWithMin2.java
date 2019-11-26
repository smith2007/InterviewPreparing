package stack;

public class StackWithMin2<T extends Comparable<T>> {

    Node<T> top;

    static class Node<T> {
        T value;
        Node<T> next;
        T currentMin;

        public Node(T value, Node<T> next, T currentMin) {
            this.value = value;
            this.next = next;
            this.currentMin = currentMin;
        }
    }

    void push(T elm) {
        if (top == null) {
            top = new Node<>(elm, null, elm);
        } else {

            if (elm.compareTo(top.currentMin) < 0) {
                top = new Node<>(elm, top, elm);
            } else {
                top = new Node<>(elm, top, top.currentMin);
            }
        }
    }

    T pop() {
        if (top == null) {
            return null;
        } else {
            T value = top.value;
            Node<T> newTop = top.next;
            top = newTop;
            return value;
        }
    }

    T min() {
        if (top == null) {
            return null;
        }
        return top.currentMin;
    }

    void print() {
        if (top == null) {
            return;
        }
        Node<T> elm = top;
        while (true) {
            System.out.println(elm.value);
            if (elm.next == null) {
                break;
            } else {
                elm = elm.next;
            }
        }
    }

    public static void main(String[] args) {
        StackWithMin2<Integer> stack = new StackWithMin2<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(0);

        stack.print();

        System.out.println("Min elm is " + stack.min());


        System.out.println("Extracted elm is " + stack.pop());

        stack.print();


        System.out.println("Min elm is " + stack.min());
    }

}
