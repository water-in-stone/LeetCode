package leetcode.array;

/**
 * @author baikal on 2019-03-10
 * @project Algorithm
 */
public class _283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
