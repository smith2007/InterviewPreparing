package linkedlist.myown;

public class ListNode {

    public ListNode next;
    public Integer value;

    public ListNode(Integer value) {
        this.value = value;
    }

    public ListNode(ListNode next, Integer value) {
        this.next = next;
        this.value = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public Integer getValue() {
        return value;
    }
}
