package leetcode.array;

/**
 * @author baikal on 2019年08月21日
 * @project Algorithm
 */
public class _287_FindDuplicateNumber {
  public static int findDuplicate(int[] nums) {
    int n1 = nums[0];
    int n2 = nums[0];
    do {
      n1 = nums[n1];
      n2 = nums[nums[n2]];
    } while (n1 != n2);

    int p1 = nums[0];
    int p2 = n2;
    while (p1 != p2) {
      p1 = nums[p1];
      p2 = nums[p2];
    }

    return p1;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 3, 4, 2, 2 };

    int res = findDuplicate(nums);
    System.out.println(res);
  }
}
