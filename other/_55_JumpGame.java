package leetcode.other;

/**
 * @author baikal on 2019-03-08
 * @project Algorithm
 * 贪心算法：每次计算出最远的能跳到的那一步，然后遍历的时候进行对比，如果不能到达，则直接return false
 */
public class _55_JumpGame {
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, nums[i] + i);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(canJump(nums));
    }
}
