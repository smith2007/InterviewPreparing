package linkedlist;

import java.util.LinkedList;
import java.util.Stack;

public class LinkedListReverse2 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.forEach(e -> System.out.print(e + " "));

        System.out.println();

        reverse(linkedList);
        // 123 -> 321

        linkedList.forEach(e -> System.out.print(e + " "));
    }

    static void reverse(LinkedList<Integer> list) {
        Stack<Integer> stack = new Stack<>();

        for (Integer elm : list) {
            stack.push(elm);
        }

        for (Integer elm : stack) {

        }


    }
}
