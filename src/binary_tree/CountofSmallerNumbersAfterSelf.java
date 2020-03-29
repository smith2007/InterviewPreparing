package binary_tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountofSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};

        CountofSmallerNumbersAfterSelf ins = new CountofSmallerNumbersAfterSelf();
        List<Integer> list = ins.countSmaller(arr);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    /**
     * что мне приходит в голову - это идти по массиву слева направо и складывать в бланасированное дерево
     * каждый новый элемент он должен вставая на новое место понимать сколько элементов меньше себя он прошел
     */
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        TreeNode currNode = null;
        //идем с конца - для каждого итого элемента определяем кол-во элтов меньше
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = countSmaller(currNode, nums[i]);
            currNode = insert(currNode, nums[i]);
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private int countSmaller(TreeNode currNode, int val) {
        //если это мы ища наше значение упали на дно - то все ноль - нет элементов которые меньше
        if (currNode == null) {
            return 0;
        }

        //если нашли нашу ноду - зашибись, это она
        if (currNode.val == val) {
            return currNode.numberOfNodesSmaller;
        }

        if (val < currNode.val) {
            return countSmaller(currNode.left, val);
        }

        return 1 + currNode.numberOfNodesSmaller + countSmaller(currNode.right, val);
    }

    //вот это прикольно - каждый раз когда мы вставляем новый элемент в дерево - он возвращает
    //инстанс этой ноды
    //ну дерево не балансированное будет
    //то есть оно будет перекосоебенное
    //добавляем ноды просто по принципу больше - меньше
    //и все
    private TreeNode insert(TreeNode currNode, int val) {

        if (currNode == null) {
            return new TreeNode(0, val);
        }

        if (val < currNode.val) {
            currNode.left = insert(currNode.left, val);
            currNode.numberOfNodesSmaller++;
            return currNode;
        } else {
            currNode.right = insert(currNode.right, val);
            return currNode;
        }
    }

    private static class TreeNode {

        int numberOfNodesSmaller;
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int numberOfNodesSmaller, int val) {
            this.numberOfNodesSmaller = numberOfNodesSmaller;
            this.val = val;
        }
    }
}
