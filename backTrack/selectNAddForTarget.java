package leetcode.backTrack;

/**
 * @project Algorithm 从一个无序，不相等的数组中，选取N个数，使其和为M 递归的写法，是回溯法的思路
 */
public class selectNAddForTarget {
    static int count = 0;

    public static int countWaysAddToTarget(int[] nums, int N, int M) {
        // dfs(nums, N, M);
        helper(nums, 0, M, N, 0);
        return count;
    }

    public static void helper(int[] nums, int start, int target, int N, int size) {
        if (size > N) {
            // 当累加数超过N时，直接return
            return;
        } else if (size == N) {
            // 判断是否和等于target
            if (target == 0) {
                count++;
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                helper(nums, i + 1, target - nums[i], N, size + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 8, 6, 2, 3 };

        int res = countWaysAddToTarget(nums, 3, 11);
        System.out.println(res);
    }
}
