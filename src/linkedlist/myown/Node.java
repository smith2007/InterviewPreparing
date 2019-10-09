package linkedlist.myown;

public class Node {

    private Node next;
    private Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Node next, Integer value) {
        this.next = next;
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public Integer getValue() {
        return value;
    }
}
