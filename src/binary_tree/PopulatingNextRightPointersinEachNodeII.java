package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

    public static void main(String[] args) {

        Node root = stringToTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]");
        Node connect = connect(root);

        System.out.println(connect);
    }

    /**
     * тут подход чуть чуть отличается от предыдущей задачи, поскольку мы не знаем состав нашего бин дерева,
     * там может быть все что угодно любые ноды на разных уровнях хз где
     * для корректного проставления ссылок мы используем dummy ноду как бы темповую
     * она нам нужна поскольку мы будем таскать ссобой всегда prev ноду для каждой текущей
     */
    static Node connect(Node root) {
        Node curr = root;
        Node dummy = new Node(0);
        Node prev = dummy;

        while (curr != null) {
            // вот тут мы рассматриваем строчку целиком
            // будем крутится в цикле до тех пор пока наша строка - а именно нода curr не приведет нас к null
            //в цикле мы расставляем ссылки для ДЕТЕЙ наших нод в нашей строчке!
            while (curr != null) {
                //с детьми мы работаем путем таскания ссылки на предыдущий элемент
                //что бы не рушить элегантность кода сначала мы подключаем кэтому делу dummy ноду нулевую
                //она как бы будет ссылаться на каждую начальную и выступть в качестве прева
                //ничего страшного в этом нет потому что она не пойдет в результирующее дерево
                // так как она (эта дамми) нода ссылается а не на нее ссылаются
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }

                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                //дальше идем по нашей строчке
                curr = curr.next;
            }

            curr = dummy.next;
            dummy.next = null;
            prev = dummy;
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

        public Node(int val) {
            this.val = val;
        }
    }


    private static Node stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new Node(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new Node(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
