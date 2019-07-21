package leetcode.array;

/**
 * @author baikal on 2019-03-16
 * @project Algorithm
 *
 *
 * 使用max记录局部极大值，使用end标记这个局部最大值应该出现的位置，比如数组内部出现了一个比较大的数，怎么办呢？ 只要后面的数比它小，
 * 那么end就记录下来当前位置，直到出现比他大的数字，max值被替换，说明我们已经找到，这个局部 极大值应该存放的位置，就这样持续遍历到尾，
 * 期间可能出现好几个局部极大值，那么end一定会越来越靠后，即它表示局部最大值 组成的集合中最大的那个值应该存放的位置。
 *
 * 同理，从后往前查找，用min表示局部极小值，star标记局部极小值应该存放的正确位置，持续遍历整个数组，若期间出现 好几个局部极小，
 * star一定越来越靠前，即它表示局部极小值组成的集合中最小的那个值应该存放的位置。
 * 如此看来，我们发现一个极大的数放错位置了，他应该放在end之歌位置,同时，一个极小的数也错了，他应该在star位置，
 * 那么，这个最短的子序列长度我们就知道了，它就是end-star+1；
 *
 * */
public class _581_FindUnsortedSubarray {
  public static int findUnsortedSubarray(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length == 1 || nums.length == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      max = Math.max(max, nums[i]);
      if (nums[i] < max) {
        right = i;
      }
    }

    for (int i = length - 1; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      if (nums[i] > min) {
        left = i;
      }
    }

    return right == 0 && left == 0 ? 0 : right - left + 1;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
    // int[] nums = { 1, 2, 3, 4 };
    // int[] nums = { 4, 3, 2, 1 };
    int res = findUnsortedSubarray(nums);
    System.out.println(res);
  }
}
