package leetcode.binarySearch;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm 二分查找的变种，每次在搜索时判断左右两个边界的值和目标值 充分利用数组中有一部分已经是有序的这个事实
 * 
 */
public class _33_SearchInRotatedSortedArray_2 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[begin] <= nums[mid]) {
                // 寻找正常的二分排序，对无序数组进行拆分，以nums[mid]和nums[begin]的值进行比较
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid - 1; // 确保[left, mid - 1]中所有元素是完全升序的
                } else {
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 4, 5, 6, 7, 0};
        // int[] nums = {6, 7, 0, 1, 2, 3, 4};
        // int[] nums = { 4, 5, 6, 7, 0, 2, 3 };
        int[] nums = { 5, 1, 2, 3, 4 };
        // {0, 1, 2, 4, 5, 6, 7};
        System.out.println(search(nums, 4));
    }
}
