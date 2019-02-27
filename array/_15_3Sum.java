package leetcode.array;

import leetcode.list.ListNode;

import java.util.*;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 * <p>
 * 1.先把数组排序
 * 2.两次for循环数组，且二分查找第3个数
 * 3.整体时间是O(n ^ 2)
 */
public class _15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> empty = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return empty;
        }

        Arrays.sort(nums);

        int length = nums.length;
        // 用ArrayList来做多态
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int negativeThirdNum = -(nums[i] + nums[j]);
                int thirdNumIndex = Arrays.binarySearch(nums, j + 1, length, negativeThirdNum);
                // 代表第三个数已找到
                if (thirdNumIndex > j) {
                    if (res.size() > 0) {
                        // 做去重处理
                        boolean isExisted = false;
                        for (List<Integer> subList : res) {
                            if (subList.get(0) == nums[i] && subList.get(1) == nums[j]) {
                                isExisted = true;
                            }
                        }
                        if (!isExisted) {
                            res.add(Arrays.asList(nums[i], nums[j], negativeThirdNum));
                        }
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], negativeThirdNum));
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] test = {-1, 0, 1, 2, -1, -4};
//        int[] test = {0, 0, 0};
        int[] test = {1, 2, -2, -1};

        System.out.println(threeSum(test));
    }
}
