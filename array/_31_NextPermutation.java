package leetcode.array;

/**
 * @author baikal on 2019-02-27
 * @project Algorithm
 * <p>
 * 其实就是从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个
 * 最小的比nums[i]大的元素交换。交换后，再把nums[i+1]到nums[nums.length-1]排序，就ok了
 */
public class _31_NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new Error("error");
        }

        int length = nums.length;
        int i = length - 2;
        int j = length - 1;

        // 寻找第1个逆序元素
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);

    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);

        System.out.println(nums);
    }
}
