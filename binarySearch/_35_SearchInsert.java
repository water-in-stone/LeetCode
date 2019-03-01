package leetcode.binarySearch;

/**
 * @author baikal on 2019-02-25
 * @project Algorithm
 * 二分查找的改进版
 */
public class _35_SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new Error("error");
        }
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        boolean isFinded = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                res = mid;
                isFinded = true;
                break;
            }
        }

        return isFinded ? res : left;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 5, 6};
        System.out.println(searchInsert(test, 4));
    }
}
