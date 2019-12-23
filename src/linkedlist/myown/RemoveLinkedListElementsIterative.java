package linkedlist.myown;

public class RemoveLinkedListElementsIterative {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        //дошли до конца, уперлись в стенку либо в налл
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;
        //вот тут без всяких prev
        //обходимся ТОЛЬКО тем что есть

        //каррент элемент на самом деле для нас это curr.next
        //и все, мы на основе него крутимся в цикле
        //перекидывая ссылки
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                //если у нас перед носом длинный чейн из цифр тогда
                //идем вперед, curr НЕ трогая!!!
                curr.next = curr.next.next;
            } else {
                //и когда при очередной итерации мы встретимся с ситуацией что curr
                //не равен валу, мы спокойно перебросим ссылочку
                curr = curr.next;
            }
        }

        return head;
    }
}
