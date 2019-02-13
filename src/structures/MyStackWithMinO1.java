package structures;


public class MyStackWithMinO1 {


    private MyNode top;

    /**
     * есть более интересное решение которое работает за время О(1)
     * все банально тупо - берем и к каждой ноде добавляем новое поле - локальный минимум
     * это то число котое является минимум для этой вершины стека
     * то есть когда мы будем брать минимум то мы просто возьмем top и спросим у него
     * кто для тебя является минимумом - гениально
     */
    static class MyNode {
        private Integer data;
        private Integer localMinimum;
        private MyNode next;

        public MyNode(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "data=" + data +
                    '}';
        }

    }


    public void push(Integer newItem) {
        MyNode newTop = new MyNode(newItem);
        if (top == null) {
            top = newTop;
            top.localMinimum = newItem;
        } else {
            MyNode oldTop = top;
            top = newTop;
            top.next = oldTop;
            if (newItem < oldTop.localMinimum) {
                top.localMinimum = newItem;
            } else {
                top.localMinimum = oldTop.localMinimum;
            }
        }
    }

    public Integer pop() {
        if (top == null) {
            return null;
        } else {
            MyNode result = top;
            top = top.next;
            return result.data;
        }

    }

    public Integer min() {
        return this.top.localMinimum;
    }


    public static void main(String[] args) {
        MyStackWithMinO1 myStack = new MyStackWithMinO1();
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
