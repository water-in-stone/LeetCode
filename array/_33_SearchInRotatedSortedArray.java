package leetcode.array;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 * 二分查找的变种，这里将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。
 * 无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 */
public class _33_SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null) {
            return Integer.MAX_VALUE;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                // 此时代表[left, mid]是一个有序数组
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // 在左侧进行正常的有序二分查找
                } else {
                    left = mid + 1;
                }
            } else {
                // 右侧是完全递增的正常数组R
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // 在右侧进行正常的有序二分查找
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 4, 5, 6, 7, 0};
//        int[] nums = {6, 7, 0, 1, 2, 3, 4};
        int[] nums = {4, 5, 6, 7, 0, 2, 3};
        // {0, 1, 2, 4, 5, 6, 7};
        System.out.println(search(nums, 0));
    }
}
