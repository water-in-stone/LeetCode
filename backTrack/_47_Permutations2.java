package leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baikal on 2019-03-02
 * @project Algorithm
 */
public class _47_Permutations2 {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 因为可能存在重复元素，所以先排序
        Arrays.sort(nums);

        ArrayList<Integer> temp = new ArrayList<>();
        backTrack(temp, nums, new boolean[nums.length]);

        return res;

    }

    public static void backTrack(ArrayList<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
                res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 避免添加重复的排列信息
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                temp.add(nums[i]);
                used[i] = true;
                backTrack(new ArrayList<>(temp), nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
//        int[] nums = {10, 1, 2, 7, 6, 5};
        int[] nums = {1, 1, 3};
        List<List<Integer>> res = permuteUnique(nums);

        System.out.println(res);
    }
}
