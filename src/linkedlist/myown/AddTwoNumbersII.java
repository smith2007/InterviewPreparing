package linkedlist.myown;

import java.util.Stack;

public class AddTwoNumbersII {

    public static void main(String[] args) {

        ListNode f1 = new ListNode(7);
        ListNode f2 = new ListNode(2);
        f1.next = f2;
        ListNode f3 = new ListNode(4);
        f2.next = f3;
        ListNode f4 = new ListNode(3);
        f3.next = f4;

        ListNode s1 = new ListNode(5);
        ListNode s2 = new ListNode(6);
        s1.next = s2;
        ListNode s3 = new ListNode(4);
        s2.next = s3;

        AddTwoNumbersII numbersII = new AddTwoNumbersII();
        ListNode listNode = numbersII.addTwoNumbers(f1, s1);
        System.out.println(listNode.val);

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //накладываем в стеки
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        //первый и второй
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sumCollector = 0;//формируем сумм - как коллектора

        ListNode сurrNode = new ListNode(0);

        //раскручиваем цикл на двух стеках до тех пор пока они оба не опустеют
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) {
                //накидываем в коллектор сумм т.е для числа 7243 состояние стека будет 3427
                sumCollector += s1.pop();
            }
            if (!s2.empty()) {
                sumCollector += s2.pop();
            }
            //внимание тут делается очень своеобразный трюк - мы строим новый линкед лист как бы пятясь назад
            //сначал построили ноду currNode, засетили ее в ноль
            //потом сделали сложение
            //а затем надстраиваем перед ней еще одну ноду, назовем ее newHeadNode(0)->currNode
            //и положим туда остаток если надо
            сurrNode.val = sumCollector % 10;
            ListNode newHeadNode = new ListNode(sumCollector / 10);
            newHeadNode.next = сurrNode;
            сurrNode = newHeadNode;
            sumCollector /= 10;
        }

        return сurrNode.val == 0 ? сurrNode.next : сurrNode;
    }

}
