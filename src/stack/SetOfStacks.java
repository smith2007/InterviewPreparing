package stack;

import java.util.LinkedList;

public class SetOfStacks {

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();

        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);

        System.out.println(setOfStacks.howManySubStacks());

        System.out.println("Extracted elm " + setOfStacks.pop());

        System.out.println(setOfStacks.howManySubStacks());
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        System.out.println(setOfStacks.howManySubStacks());
    }

    LinkedList<Stack> staks;

    public SetOfStacks() {
        this.staks = new LinkedList<>();
    }

    void push(Integer elm) {
        if (staks.isEmpty()) {
            Stack stack = new Stack(3);
            stack.push(elm);
            staks.push(stack);
        } else {
            boolean result = staks.peek().push(elm);
            if (!result) {
                Stack stack = new Stack(3);
                stack.push(elm);
                staks.push(stack);
            }
        }
    }

    Integer pop() {
        if (staks.isEmpty()) {
            return null;
        }
        Integer elm = staks.peek().pop();
        if (elm != null) {
            if (staks.peek().size == 0) {
                staks.pop();
            }
            return elm;
        } else {
            if (staks.isEmpty()) {
                return null;
            }
            staks.pop();
            if (staks.isEmpty()) {
                return null;
            }
            Stack previousSubStack = staks.pop();
            if (previousSubStack != null) {
                return previousSubStack.pop();
            } else {
                return null;
            }
        }
    }

    Integer howManySubStacks() {
        return staks.size();
    }

    static class Stack {
        Node top;
        int size;
        int capacity;

        Stack(int capacity) {
            this.capacity = capacity;
        }

        boolean push(Integer value) {
            if (size + 1 > capacity) {
                return false;
            }
            if (top == null) {
                top = new Node(value, null);
            } else {
                top = new Node(value, top.next);
            }
            size++;
            return true;
        }

        Integer pop() {
            if (top == null) {
                return null;
            }
            Integer result = top.value;
            top = top.next;
            size--;
            return result;
        }
    }


    static class Node {
        Integer value;
        Node next;

        Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
