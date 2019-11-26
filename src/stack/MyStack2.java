package stack;

public class MyStack2<T> {


    public static void main(String[] args) {
        MyStack2<Integer> stack2 = new MyStack2<>();

        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);

        stack2.print();

        System.out.println();

        stack2.pop();
        stack2.pop();
        stack2.pop();

        stack2.print();
    }

    // стек, что это и что должен иметь
    // ну во первых это структура данны которая работает по принципу FILO или LIFO
    // соотв у стека есть top - вершина
    // а так же ссылка на ниже стоящий элемент
    private Node<T> top;

    static class Node<T> {
        Node next;
        T value;

        Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    void push(T value) {
        if (value == null) {
            return;
        }
        if (top == null) {
            top = new Node<>(null, value);
        } else {
            top = new Node<>(top, value);
        }
    }

    T pop() {
        if (top == null) {
            return null;
        } else {
            Node<T> temp = top;
            top = top.next;
            return temp.value;
        }
    }

    void print() {
        if (top == null) {
            return;
        } else {
            Node<T> node = this.top;
            while (true) {
                System.out.print(node.value);
                if (node.next == null) {
                    break;
                }
                node = node.next;
            }
        }
    }


}
