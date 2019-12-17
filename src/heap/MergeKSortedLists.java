package heap;

import linkedlist.myown.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /**
     * есть вариант сделать это за время O(n log k), решение в следующем,
     * будем держать кучу, PriorityQueue, где самые приоритетные это минимальные элементы
     * берем, проходим по первым элементам каждого из списков, заполняем нашу кучу k элементами
     * потом крутимся в цикле и набиваем финальный список путем вытаскивания
     * из PriorityQueue и последующего добавления в нее следующего за вытащенным элементов,
     * попутно проверяем что вытащенный имеет next - ссылку на следующий, иначе упадем в NPE
     *
     * https://leetcode.com/problems/merge-k-sorted-lists/
     */
    static ListNode mergeKLists(ListNode[] arr) {

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(ListNode::getVal));

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        ListNode root = heap.poll();

        ListNode curr = root;

        while (!heap.isEmpty()) {
            ListNode elm = heap.poll();
            curr.next = elm;
            curr = curr.next;
            if (elm.next != null) {
                heap.add(elm.next);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        ListNode[] arr = {first, second, third};

        ListNode res = mergeKLists(arr);

        while (true) {
            System.out.println(res.getVal());

            if (res.next != null) {
                res = res.next;
            } else {
                break;
            }
        }

    }


}
