package leetcode.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author baikal on 2019-03-07
 * @project Algorithm
 */
public class _215_KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new Error("error");
        }
        Arrays.sort(nums);
        int kthValue = nums[0];
        for (int i = nums.length - 1; i >=0 ; i--) {

        }
        return 0;
    }

    public static ArrayList quickSort(int[] nums) {
        if (nums.length == 0) return null;
        int pivot = nums[0];
        boolean isPivotFinded = false;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                left.add(nums[i]);
            } else if (nums[i] == pivot && !isPivotFinded) {
                isPivotFinded = true;
                continue;
            } else {
                right.add(nums[i]);
            }
        }

        return new ArrayList(Arrays.asList(left, pivot, right));
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }
}
