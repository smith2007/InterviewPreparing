package stack;


public class MyStackWithAdditionalStack {

    private MyNode top;

    //это дополнительныц стек
    private MyStack<Integer> additionalStackForMins;

    /**
     *
     есть еще идея немножко укоротить - а что если сделать новый стек - дополнительный - и в нем мы будем харнить минимумы

     добавлять их и удалять тогда когда они поменяются

     это будет лучше - так при большом объеме стека мы не дублируем везде локальный минимум

     */
    static class MyNode {
        private Integer data;
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
            additionalStackForMins = new MyStack<>();
            additionalStackForMins.push(newItem);
        } else {
            MyNode oldTop = top;
            top = newTop;
            top.next = oldTop;
            if (newItem < additionalStackForMins.peek()) {
                additionalStackForMins.push(newItem);
            }
        }
    }

    public Integer pop() {
        if (top == null) {
            return null;
        } else {
            MyNode result = top;
            top = top.next;
            Integer resultData = result.data;
            if (top == null) {
                additionalStackForMins = null;
                return resultData;
            } else if (top.data > additionalStackForMins.peek()) {
                additionalStackForMins.pop();
            }
            return resultData;
        }
    }

    public Integer min() {
        if (additionalStackForMins == null) {
            return null;
        }
        return additionalStackForMins.peek();
    }


    public static void main(String[] args) {
        MyStackWithAdditionalStack myStack = new MyStackWithAdditionalStack();
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
