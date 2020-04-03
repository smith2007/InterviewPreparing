package binary_tree;

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {

        int val;
        int closest = root.val;

        while (root != null) {
            val = root.val;

            //крутимся в цикле и  Math.abs(val - target) < Math.abs(closest - target)
            //если да - обновляем closest
            if (Math.abs(val - target) < Math.abs(closest - target)) {
                closest = val;
            }

            //дальше надо смотреть куда идти влево или вправо
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }

}
