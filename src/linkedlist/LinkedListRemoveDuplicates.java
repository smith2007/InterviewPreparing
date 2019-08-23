package linkedlist;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListRemoveDuplicates {

    public static void main(String[] args) {


        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);

        removeDuplicates(list);

        list.forEach(e -> System.out.print(e + " "));

        // 1 2 3
    }

    //самый тупой это перегнать в сет, а потом из сета - list - время О(n) - память О(n)
    //еще один самый тупой - это создать темп массив и двойным циклом искать дубли О(n2)

    /**
     * правильный подход - сначала отсортировать массив
     * затем пустить итератор
     * и брать текущий элемент и следующий
     * в отсортированом они дубликаты будут рядом
     * далее удаляем пока не наткнем на что либо отличное от текущего
     *
     */
    static void removeDuplicates(LinkedList<Integer> list) {
        Collections.sort(list);

        Iterator<Integer> itr = list.iterator();

        if (itr.hasNext()) {
            Integer previous = itr.next();

            while (itr.hasNext()) {
                Integer current = itr.next();

                if (previous.equals(current)) {
                    itr.remove();
                } else {
                    previous = current;
                }
            }
        }

    }
}
