package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-03-11
 * @project Algorithm
 */
public class _322_CoinChange {
  // 记录使用硬币数
  static int[] memoStore;

  public static int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return -1;
    }
    // 初始化存储数组，这样不用
    memoStore = new int[amount + 1];
    for (int i = 0; i < memoStore.length; i++) {
      memoStore[i] = -2;
    }

    return helper(coins, amount);
  }

  public static int helper(int[] coins, int target) {
    if (memoStore[target] != -2) {
      // 代表之前已经计算过
      return memoStore[target];
    } else if (target == 0) {
      // 代表当前硬币可以直接d达成目标
      return 0;
    } else {
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i < coins.length; i++) {
        if (target - coins[i] < 0)
          // 代表这个目标金钱无法完成，直接剪枝
          continue;
        int sub = helper(coins, target - coins[i]);
        if (sub == -1) {
          // 代表此问题无解
          continue;
        }
        ans = Math.min(ans, sub + 1);
      }
      // 记录本轮答案
      memoStore[target] = ans == Integer.MAX_VALUE ? -1 : ans;
      return memoStore[target];
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    int res = coinChange(nums, 8);

    System.out.println(res);
  }
}
