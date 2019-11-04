package linkedlist.myown;

public class ListNode {

    public ListNode next;
    public Integer val;

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(ListNode next, Integer val) {
        this.next = next;
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public Integer getVal() {
        return val;
    }
}
