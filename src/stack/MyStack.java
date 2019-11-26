package stack;

public class MyStack<T> {

    private MyNode<T> top;

    private static class MyNode<T> {
        private T data;
        private MyNode<T> next;

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


    public void push(T newItem) {
        MyNode<T> newTop = new MyNode<>(newItem);
        if (top == null) {
            top = newTop;
        } else {
            MyNode<T> oldTop = top;
            top = newTop;
            top.next = oldTop;
        }
    }

    public T pop() {
        if (top == null) {
            return null;
        } else {
            MyNode<T> result = top;
            top = top.next;
            return result.data;
        }

    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }


    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
