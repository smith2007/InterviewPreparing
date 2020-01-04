package data_structures;

public class MyQueue2<T> {

    // очередь это такая структура данных
    // которая работает по принципу FIFO
    // первый пришел и встал в очередь, первым и выйдешь из нее
    // у односвязной очереди есть ссылка на следующий элемент
    // так же на уровне класса надо задекларировать ноду которая содержит val
    // у самого инстанса очереди при этом есть ссылки только на первый и на предыдущий
    // потому что добавление элемента приходится в конец
    // а удаление в начало


    Node<T> first;
    Node<T> last;

    void push(T value) {
        if (last == null) {
            Node<T> newElm = new Node<>(null, value);
            this.last = newElm;
            this.first = newElm;
        } else {
            Node<T> exLast = this.last;
            Node<T> newLast = new Node<>(null, value);
            exLast.previous = newLast;
            last = newLast;
        }
    }

    T poll() {
        if (first == null) {
            return null;
        } else {
            Node<T> result = this.first;
            Node newFirst = this.first.previous;
            if (newFirst == null) {
                last = null;
            }
            this.first = newFirst;
            return result.value;
        }

    }

    void print() {

        Node<T> printNode = this.first;

        while (printNode != null) {
            System.out.print(printNode.value);
            printNode = printNode.previous;
        }

    }


    static class Node<T> {
        Node previous;
        T value;

        Node(Node previous, T value) {
            this.previous = previous;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        MyQueue2<Integer> myQueue2 = new MyQueue2<>();
        myQueue2.push(1);
        myQueue2.push(2);
        myQueue2.push(3);
        myQueue2.push(4);

        myQueue2.print();

        System.out.println();
        myQueue2.poll();
        myQueue2.poll();
        myQueue2.print();
    }

}

