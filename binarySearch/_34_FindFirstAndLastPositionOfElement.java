package leetcode.binarySearch;

/**
 * @author baikal on 2019-03-01
 * @project Algorithm
 *
 * 二分法找出对应的index，然后利用数组是有序的这个特点，向左右两边扩展
 */
public class _34_FindFirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int targetIndex = -1;
        int mid = -1;
        int start = -1;
        int end = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                targetIndex = mid;
                end = targetIndex;
                start = targetIndex;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        if (targetIndex == -1) {
            return new int[]{-1, -1};
        } else {
            // 找出target元素的左侧索引
            for (int i = targetIndex + 1; i < length; i++) {
                if (nums[i] != target) {
                    break;
                }
                end = i;
            }

            for (int j = targetIndex - 1; j >= 0; j--) {
                if (nums[j] != target) {
                    break;
                }
                start = j;
            }

            return new int[]{start, end};
        }

    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 8, 8, 9};
//        int[] nums = {1, 2, 8, 8};
//        int[] nums = {8, 8, 9, 10, 31, 42};
//        int[] nums = {7, 9, 10, 31, 42};
        int[] nums = {7};

        int[] res = searchRange(nums, 8);
        System.out.println(res[0] + " " + res[1]);
    }
}
