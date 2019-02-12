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
        System.out.println(findByEndIndex(1, myQueue));
    }

    //самое первое что мне приходит в голову это
    //пробежать по списку посчитать общее кол-во
    //потом взять и отнять нащ К от общего кол-ва
    //и найти этот элемент
    //сложность О(n)
    static Integer findByEndIndex(int k, MyQueue<Integer> queue){

        return 0;
    }
}
