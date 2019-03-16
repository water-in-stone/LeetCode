package leetcode.array;

import java.util.*;

/**
 * @author baikal on 2019-03-16
 * @project Algorithm
 *
 * 数组里的数字都在 [1, n]，且要求不适用额外空间，因此可以想到该题为套路题：对原位置上的数字移动/加减/位运算等解法。
 * 此题常规可以选用反转对应位置上数字的方法：把出现的数字的对应位上的数字变为负数，然后遍历找出那些正数，其下标+1则为没有出现过的数字
 * 数组的长度恰巧为n
 */
public class _448_FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 3, 7};
        List<Integer> res = findDisappearedNumbers(nums);

        System.out.println(res);
    }
}
