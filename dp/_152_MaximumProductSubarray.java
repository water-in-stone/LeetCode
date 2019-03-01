package leetcode.dp;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 * 使用DP，且因为这里存在负负得正的情况，所以用两个数组来存储
 * dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
 * dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
 */
public class _152_MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            if (max < dpMax[i]) {
                max = dpMax[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4, 5};
//        int[] nums = {-2, 0, -1};
//        int[] nums = {-2, 0};
        int[] nums = {2, -1, 1, 1};
//        int[] nums = {-2, 3, -4};
//        int[] nums = {-4, 5, 3, -2, 1};
//        int[] nums = {-2, 3, 5, -4, -1, 7, 8};

        System.out.println(maxProduct(nums));
    }
}
