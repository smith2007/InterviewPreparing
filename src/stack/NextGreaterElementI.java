package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {


    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};

        for (int i : nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }
    }

    /**
     * работаем через стек по принципу daily temperatures
     *
     */
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int elm : nums2) {

            if (stack.isEmpty()) {
                stack.push(elm);
            } else {
                while (!stack.isEmpty() && stack.peek() < elm) {
                    Integer poped = stack.pop();
                    map.put(poped, elm);
                }
                stack.push(elm);
            }

        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;

    }
}
