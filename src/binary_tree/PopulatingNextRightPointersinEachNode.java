package binary_tree;

public class PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {

        StringToNodeBuilder.stringToTreeNode("[1,2,3,4,5,6,7]");
    }

    /**
     * опишу так - действуем по принципу иерархии и треугольника
     * где у нас постоянно есть head элемент и мы линкуем его детей
     */
    static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        // начинаем с рута - помечаем его как самую левую ноду
        Node leftmost = root;

        // как только мы достигнем самого нижнего края
        //будем выходить из цикла
        while (leftmost.left != null) {


            //итерируем линкед лист начиная с головного элемента
            //используем ссылки на некст проставленными ранее
            //другим хэдом этажом выше
            //работаем с детьми, левым и правым линкуем их
            //правого сына линкуем с левым сыном нашего некста
            Node head = leftmost;

            while (head != null) {

                // линкуем левого сына с правым сыном
                head.left.next = head.right;

                // ессли некст у головы не пустой
                if (head.next != null) {
                    //то правого сына линкуем с левым сыном нашего некста
                    head.right.next = head.next.left;
                }

                // не и все следующий хэд будетнаш следующий элемен
                head = head.next;
            }

            // прееходим на сл уровень
            leftmost = leftmost.left;
        }

        return root;

    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
