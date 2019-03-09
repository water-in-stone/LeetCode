package leetcode.array;

import java.util.*;

/**
 * @author baikal on 2019-03-07
 * @project Algorithm
 */
public class _215_KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new Error("error");
        }
        Arrays.sort(nums);
        int index = nums.length - k;

        return nums[index];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }
}
