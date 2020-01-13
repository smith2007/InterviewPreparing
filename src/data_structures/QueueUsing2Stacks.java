package data_structures;

import java.util.LinkedList;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        QueueUsing2Stacks queue = new QueueUsing2Stacks();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private final LinkedList<Integer> stack1 = new LinkedList<>();
    private final LinkedList<Integer> stack2 = new LinkedList<>();

    void add(Integer value) {
        stack1.push(value);
    }

    Integer poll() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            return null;
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            Integer elm = stack1.pop();
            stack2.push(elm);
        }
        return stack2.pop();

    }
}
