package leetcode.backTrack;

import java.util.*;

/**
 * @author baikal on 2019-03-02
 * @project Algorithm
 */
public class _46_Permutations {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 上手就是一个排序
        Arrays.sort(nums);

        ArrayList<Integer> temp = new ArrayList<>();
        backTrack(temp, nums);

        return res;


    }

    public static void backTrack(ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 避免添加重复元素
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(new ArrayList<>(temp), nums);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {10, 1, 2, 7, 6, 5};
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);

        System.out.println(res);
    }
}
