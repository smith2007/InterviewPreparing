package structures;

public class MyQueue<T> {

    public static void main(String[] args) {
        MyQueue<String> stringMyQueue = new MyQueue<>();

        stringMyQueue.push("first");

        System.out.println(stringMyQueue);

        stringMyQueue.push("second");

        System.out.println(stringMyQueue);

        stringMyQueue.push("third");

        System.out.println(stringMyQueue);


        stringMyQueue.poll();

        System.out.println(stringMyQueue);
    }


    static class MyNode<T> {
        private T data;
        private MyNode<T> next; //ссылка на предыдущий следующий в очереди элемент

        public MyNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "data=" + data +
                    '}';
        }

        public T getData() {
            return data;
        }

        public MyNode<T> getNext() {
            return next;
        }
    }

    private MyNode<T> first;
    private MyNode<T> last;

    public void push(T data) {
        MyNode<T> newItem = new MyNode<>(data);
        if (last != null) {
            last.next = newItem; //старый ласт его ссылку на следующий в очереди присваиваем на наш новый ласт
        }

        last = newItem;

        if (first == null) {
            first = last;
        }
    }

    public void poll() {
        if (first == null) {
            throw new RuntimeException("first element is null. Nothing to poll.");
        }
        first = first.next;

        if (first == null) {
            last = null;
        }
    }

    public T peekFirst() {
        return this.peekFirstNode().data;
    }

    public MyNode<T> peekFirstNode() {
        if (first == null) {
            throw new RuntimeException("first element is null. Nothing to peek.");
        } else {
            return first;
        }
    }

    public MyNode<T> peekLastNode() {
        if (last == null) {
            throw new RuntimeException("last element is null. Nothing to peek.");
        } else {
            return last;
        }
    }

    public T peekLast() {
        return peekLastNode().data;
    }

    @Override
    public String toString() {
        return "structures.MyQueue{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
