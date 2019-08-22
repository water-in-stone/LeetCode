package leetcode.array;

/**
 * @author baikal on 2019-03-10
 * @project Algorithm
 */
public class _238_ProductOfArrayExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    if (nums.length == 0) {
      return new int[0];
    }

    int n = nums.length;
    int[] res = new int[n];
    // dpLeft[i]表示从[0,i]个元素的乘积
    int[] dpLeft = new int[n];
    dpLeft[0] = nums[0];
    int[] dpRight = new int[n];
    dpRight[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      dpLeft[i] = nums[i] * dpLeft[i - 1];
      dpRight[n - i - 1] = nums[n - i - 1] * dpRight[n - i];
    }
    for (int i = 0; i < n; i++) {
      int sub1 = i - 1 >= 0 ? dpLeft[i - 1] : 1;
      int sub2 = i + 1 < n ? dpRight[i + 1] : 1;
      res[i] = sub1 * sub2;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = { 0, 1, 0, 3, 12 };

    productExceptSelf(nums);
  }
}
