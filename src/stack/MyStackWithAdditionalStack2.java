package stack;


public class MyStackWithAdditionalStack2 extends MyStack<Integer> {

    private MyStack<Integer> minStack2;

    public MyStackWithAdditionalStack2() {
        this.minStack2 = new MyStack<>();
    }

    public void push(Integer newItem) {
        if (newItem < min()) {
            minStack2.push(newItem);
        }
        super.push(newItem);
    }

    public Integer pop() {
        Integer elm = super.pop();
        if (elm.equals(min())) {
            minStack2.pop();
        }
        return elm;
    }

    public Integer min() {
        if (minStack2 == null || minStack2.peek() == null) {
            return Integer.MAX_VALUE;
        } else {
            return minStack2.peek();
        }
    }


    public static void main(String[] args) {
        MyStackWithAdditionalStack2 myStack = new MyStackWithAdditionalStack2();
        myStack.push(1);
        myStack.push(2);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        myStack.push(1);
        myStack.push(1);

        /**
         * состояние стека:
         * 1 <-top
         * 1
         * 1
         * 2
         * 3
         * 4
         * 2
         * 1
         */
        myStack.pop();
        myStack.pop();
        myStack.pop();
        /**
         * состояние стека:
         * 2 <-top
         * 3
         * 4
         * 2
         */

        System.out.println("Minimum is " + myStack.min());
        // 2
    }
}
