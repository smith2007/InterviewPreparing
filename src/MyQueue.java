
public class MyQueue<T> {

    public static void main(String[] args) {
        MyQueue<String> stringMyQueue = new MyQueue<>();

        stringMyQueue.add("first");

        System.out.println(stringMyQueue);

        stringMyQueue.add("second");

        System.out.println(stringMyQueue);

        stringMyQueue.add("third");

        System.out.println(stringMyQueue);


        stringMyQueue.remove();

        System.out.println(stringMyQueue);
    }


    private static class MyNode<T> {
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
    }

    private MyNode<T> first;
    private MyNode<T> last;

    public void add(T data) {
        MyNode<T> newItem = new MyNode<>(data);
        if (last != null) {
            last.next = newItem; //старый ласт его ссылку на следующий в очереди присваиваем на наш новый ласт
        }

        last = newItem;

        if (first == null) {
            first = last;
        }
    }

    public void remove() {
        if (first == null) {
            throw new RuntimeException("first element is null. Nothing to remove.");
        }

        first = first.next;

        if (first == null) {
            last = null;
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }
}
