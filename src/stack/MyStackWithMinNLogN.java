package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyStackWithMinNLogN {

    /**
     * для того что бы сделать метод min() я добавил интересную структуру данных
     * это TreeMap то есть сортированная мапа с ключом в виде нашего элемента
     * а значением в виде массива таких элементов
     * грубо говоря она будет выглядеть вот так :
     *
     * <key> 4 </>  <val>[4,4,4,4]</>
     * <key> 5 </>  <val>[5,5]</>
     * эта мапа с массивом нужна для того что бы в наш стек поддерживал дубликаты
     * тут нельзя обойтись тупо переменной int min потому что хрен его знает сколько там
     * еще внизу таких же елементов
     *
     * какой алгоритм - мы делаем push в стек - обновляем мапу и массив в ней (добавляем или создаем)
     * мы делаем pop из стека мы обновляем мапу (уменьшаем кол-во эл-тов в массиве или удаляем совсем из мапы)
     *
     * сложность по времени: O(n log n) из-за сортировки в treeMap
     * сложность по памяти : О(n) - из-за treeMap
     */
    private TreeMap<Integer, List<Integer>> listMinimals;

    private MyNode top;

    static class MyNode {
        private Integer data;
        private MyNode next;

        public MyNode(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "data=" + data +
                    '}';
        }

    }


    public void push(Integer newItem) {
        MyNode newTop = new MyNode(newItem);
        if (top == null) {
            top = newTop;
            this.listMinimals = new TreeMap<>();
            ArrayList<Integer> newElmMinimals = new ArrayList<>();
            newElmMinimals.add(newItem);
            this.listMinimals.put(newItem, newElmMinimals);
        } else {
            MyNode oldTop = top;
            top = newTop;
            top.next = oldTop;

            List<Integer> elmMinimals = this.listMinimals.get(newItem);
            if (elmMinimals == null) {
                ArrayList<Integer> newElmMinimals = new ArrayList<>();
                newElmMinimals.add(newItem);
                this.listMinimals.put(newItem, newElmMinimals);
            } else {
                elmMinimals.add(newItem);
            }
        }
    }

    public Integer pop() {
        if (top == null) {
            return null;
        } else {
            MyNode result = top;
            top = top.next;
            Integer resultData = result.data;

            List<Integer> elmMinimals = this.listMinimals.get(resultData);
            if (elmMinimals.size() == 1) {
                listMinimals.remove(resultData);
            } else {
                elmMinimals.remove(0);
            }
            return resultData;
        }

    }

    public Integer min() {
        return this.listMinimals.firstKey();
    }


    public static void main(String[] args) {
        MyStackWithMinNLogN myStack = new MyStackWithMinNLogN();
        myStack.push(2);
        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        myStack.push(1);
        myStack.push(1);

        /**
         * состояние стека:
         * 1 <-top
         * 1
         * 1
         * 2
         * 3
         * 4
         * 2
         */

        myStack.pop();
        myStack.pop();
        myStack.pop();

        /**
         * состояние стека:
         * 2 <-top
         * 3
         * 4
         * 2
         */

        System.out.println("Minimum is " + myStack.min());

        // 2

    }
}
