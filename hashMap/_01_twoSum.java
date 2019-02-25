package leetcode.hashMap;

import java.util.*;

/**
 * @author baikal on 2019-02-24
 * @project Algorithm
 * 烂解法：2遍遍历数组，这样时间复杂度为O(n2)，空间复杂度为O(1)
 * 好解法：既然重要的是查找，那么把value作为hashMap的key，index作为存放的值，且只需要一遍循环（边储存边查找）
 */
public class _01_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int remainValue = target - nums[i];
            // 进行查找
            if (map.get(remainValue) != null) {
                return new int[] {map.get(remainValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 5, 2, 6, 8};
        int[] res = twoSum(a, 4);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
