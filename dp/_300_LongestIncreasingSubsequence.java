package leetcode.dp;

/**
 * @author baikal on 2019-02-28
 * @project Algorithm dp[i] = 遍历之前所有项j并找出max(dp[i], dp[j] + 1)
 */
public class _300_LongestIncreasingSubsequence {
  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int n = nums.length;
    int max = 0;
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      // 向前遍历所有index比i小的项，且第一印象
      for (int j = i; j >= 0; j--) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
    System.out.println(lengthOfLIS(nums));
  }
}
