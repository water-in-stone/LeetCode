package leetcode.hashMap;

import java.util.*;

/**
 * @author baikal on 2019年09月01日
 * @project Algorithm 
 * 详见：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/c-nshi-jian-nkong-jian-xiang-jie-by-charon____/ 
 * [1, 1, 1]这个例子中，暴力法重复计算了nums[1] + nums[2]，换一种思路，实际上不需要加法，
 * 只需要 nums[0] + nums[1] + nums[2] - nums[0]，
 * 再写的清晰一些，用sum[i]表示从0到i所有元素的和，那么nums[1] + nums[2] = sum[2] - sum[0]。
 * 
 * 有了大体的方向后，具体的map怎么存，key是什么，value是什么？对于这个问题来说，我们需要找到的是target k，
 * 即sum[j] - sum[i] = k (j > i)，k已知，sum[j]在迭代过程中逐步计算。需要存储的就只有sum[i]，查找sum[i]要常数时间，
 * 那么map的key应该是sum[i]。根据约束条件，value应该是当前值的下标。但是在实际实现的时候可以把这个约束隐藏在循环中，
 * 对于当前问题，要找到满足子数组的个数，value可以用来存储到当前位置，前缀和的个数，那么在找到满足的sum[i] = sum[j] - k的时候，
 * 最后的结果只需要加上map[sum[j] - k]即可。
 */
public class _560_SubarraySumEqualsK {
  public static int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int count = 0;
    int sum = 0;
    // 代表当前累加值正好等于targer
    hashMap.put(0, 1);
    for (int num : nums) {
      sum += num;
      if (hashMap.containsKey(sum - k)) {
        // 代表有区间[i,j]的累加和是target
        count += hashMap.get(sum - k);
      }
      hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 7, 5, 2, 6, 8 };
    int count = subarraySum(a, 4);

    System.out.println(count);
  }
}
