package array;

import java.util.TreeSet;

public class ContainsDuplicateIII {

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */


/*
    Clarify:
    return true if (nums[i] - nums[j]) <= t && j - i <= k

    Method1: Sliding Window

    Window size: k + 1

    if(max - min <= t) return ture;

    TC: O(k + (n-k)*k)
    SC: O(k)

    Method2: Using Balanced Binary Search Tree to reduce time to find cloest number.

    Build a size (k + 1) bbs tree
    Traverse the rest (n - k - 1) elements
    Step1: remove the last element ==> remove(nums[i - k])
    Step2: find the cloest number to the new element ==> findCloestInTree(nums[i])
    if foundElement - nums[i] <= t ==> return true
    Step3: add new element into tree ==> add(nums[i])



    https://leetcode.com/problems/contains-duplicate-iii/solution/
 */
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < nums.length; ++i) {
        // Find the successor of current element
        Integer s = set.ceiling(nums[i]);
        if (s != null && s <= nums[i] + t) return true;

        // Find the predecessor of current element
        Integer g = set.floor(nums[i]);
        if (g != null && nums[i] <= g + t) return true;

        set.add(nums[i]);
        if (set.size() > k) {
            set.remove(nums[i - k]);
        }
    }
    return false;
}
}
