package structures;

public class FindKElementInQueueStartsFromTheEnd {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(5);
        myQueue.push(4);
        myQueue.push(3);
        myQueue.push(2);
        myQueue.push(1);
        //1
        System.out.println(findByEndIndex(0, myQueue));

        System.out.println(findByEndIndex(1000, myQueue));

    }

    //самое первое что мне приходит в голову это
    //пробежать по списку посчитать общее кол-во
    //потом взять и отнять нащ К от общего кол-ва
    //и найти этот элемент
    //сложность О(n)
    static Integer findByEndIndex(int k, MyQueue<Integer> queue) {

        MyQueue.MyNode<Integer> currentNode = queue.peekFirstNode();
        int size = 0;
        while (currentNode != null) {
            if (currentNode.getNext() != null) {
                size++;
            }
            currentNode = currentNode.getNext();
        }

        if (k > size) {
            throw new RuntimeException("K is too big. Total size is " + (size + 1));
        }

        int indexOfResultElm = size - k;
        int pointer = 0;
        currentNode = queue.peekFirstNode();
        while (currentNode != null) {
            if (pointer == indexOfResultElm) {
                return currentNode.getData();
            } else {
                pointer++;
                currentNode = currentNode.getNext();
            }

        }
        throw new RuntimeException("Something got wrong and you are mudak");
    }
}
