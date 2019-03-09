package leetcode.array;

/**
 * @author baikal on 2019-03-09
 * @project Algorithm
 * 荷兰国旗问题
 */
public class _75_SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int end = nums.length - 1;
        int begin = 0;
        int current = 0;

        while (current <= end) {
            if (nums[current] == 0){
                swap(nums, begin, current);
                current++;
                begin++;
            } else if(nums[current] == 1){
                current++;
            } else {
                swap(nums, current, end);
                end--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {2, 0, 1};
        sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
