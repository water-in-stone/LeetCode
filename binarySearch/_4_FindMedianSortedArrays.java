package leetcode.binarySearch;

/**
 * @author baikal on 2019-02-27
 *         详见：https://blog.csdn.net/hk2291976/article/details/51107778
 *         核心思想在于查找到用二分法在合并后的有序数组里进行查找
 */
public class _4_FindMedianSortedArrays {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;
    int l1 = 0;
    int r1 = 0;
    int l2 = 0;
    int r2 = 0;
    // 为了效率，只搜索较短的数组即可
    if (n2 < n1) {
      return findMedianSortedArrays(nums2, nums1);
    }
    // 只在nums1里进行二分搜索;
    int low1 = 0;
    // 这里将数组进行扩展，变为待#的奇数数组，所以是 2 * n1
    int high1 = 2 * n1;
    while (low1 <= high1) {
      int c1 = (low1 + high1) / 2;
      // n1 + n2 为合并后数组中中位数所处的位置，n1 + n2 - c1为nums2中对应的位置
      int c2 = n1 + n2 - c1;
      // 找出这些元素在原先数组中的位置
      // 若c1为2 * n1，则代表nums1里所有数均小于nums2[0]

      l1 = c1 <= 0 ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
      r1 = c1 >= 2 * n1 ? Integer.MAX_VALUE : nums1[c1 / 2];
      l2 = c2 <= 0 ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
      r2 = c2 >= 2 * n2 ? Integer.MAX_VALUE : nums2[c2 / 2];

      // 令其满足 L1 <= R2, L2 <= R1，则中位数可直接得到
      if (l1 > r2) {
        high1 = c1 - 1;
      } else if (l2 > r1) {
        low1 = c1 + 1;
      } else {
        break;
      }
    }

    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 2 };
    int[] nums2 = { 3, 4 };
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
}
