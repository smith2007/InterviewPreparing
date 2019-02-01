import java.util.LinkedList;

public class LinkedListReverse {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        //reverseWithRemoving(linkedList);

        reverseWithoutRemoving(linkedList);
        // 123 -> 321
    }

    //O(n)
    //O(1)
    private static LinkedList<Integer> reverseWithRemoving(LinkedList<Integer> linkedList) {
        LinkedList<Integer> result = new LinkedList<>();

        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            Integer last = linkedList.getLast();
            linkedList.removeLast();
            result.add(last);
        }
        return result;
    }


    //O(n)
    //O(n)
    private static LinkedList<Integer> reverseWithoutRemoving(LinkedList<Integer> linkedList) {
        LinkedList<Integer> result = new LinkedList<>();
        int size = linkedList.size();
        for (int i = size - 1; i >= 0; i--) {
            result.add(linkedList.get(i));
        }
        return result;
    }
}
