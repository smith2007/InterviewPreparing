package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack {

    public static void main(String[] args) {

        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
        System.out.println(stack.top());


    }

    Node top;

    TreeMap<Integer, List<Node>> map = new TreeMap<>();

    //так самое сложное тут
    //это сделать так что бы
    // можно было попать максимальный
    //элемент

    //исходя из этого обычным стеком
    //как раньше ты делал, тут уже не обойтись

    //соответственно надо держать линки на следующий
    //и на предыдущий
    //а максимум держать в какой либо структуре данных
    //например в куче

    public MaxStack() {

    }

    public void push(int x) {

        Node node = new Node(x);

        if (top == null) {
            top = node;
        } else {
            top.higher = node;
            node.lower = top;
            top = node;
        }

        List<Node> elms = map.getOrDefault(x, new ArrayList<>());
        elms.add(node);
        map.put(x, elms);
    }

    public int pop() {

        if (top == null) {
            return Integer.MIN_VALUE;
        }

        int val = top.val;
        top = top.lower;

        List<Node> nodes = map.get(val);

        Node fromMap = nodes.remove(nodes.size() - 1);

        if (nodes.isEmpty()) {
            map.remove(val);
        }

        Node prev = fromMap.higher;
        Node next = fromMap.lower;

        fromMap.higher = null;
        fromMap.lower = null;

        if (prev != null) {
            prev.lower = next;
        }
        if (next != null) {
            next.higher = prev;
        }

        return val;

    }

    public int top() {
        if (top == null) {
            return Integer.MIN_VALUE;
        }
        return top.val;
    }

    public int peekMax() {
        if (map.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return map.lastKey();
    }

    public int popMax() {

        if (top == null) {
            return Integer.MIN_VALUE;
        }

        Integer max = map.lastKey();
        List<Node> nodes = map.get(max);

        Node fromMap = nodes.remove(nodes.size() - 1);

        if (nodes.isEmpty()) {
            map.remove(max);
        }

        if (fromMap.equals(top)) {
            top = top.lower;
        }

        Node prev = fromMap.higher;
        Node next = fromMap.lower;

        fromMap.higher = null;
        fromMap.lower = null;

        if (prev != null) {
            prev.lower = next;
        }
        if (next != null) {
            next.higher = prev;
        }

        return fromMap.val;

    }

    static class Node {
        Node higher;
        Node lower;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
