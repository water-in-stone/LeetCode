package leetcode.dp;

/**
 * @author baikal on 2019-03-09
 * @project Algorithm 思路： dp[n] 代表以n为结尾的最大的子数组的和 状态转移方程：dp[n] = array[n] +
 *          dp[n-1] > array[n] ? array[n] + dp[n-1]:array[n]
 */
public class _53_MaximumSubarray_2 {
  public static int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      throw new Error("error");
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < n; i++) {
      dp[i] = nums[i] + dp[i - 1] > nums[i] ? nums[i] + dp[i - 1] : nums[i];
      max = dp[i] > max ? dp[i] : max;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println(maxSubArray(arr));
  }
}
