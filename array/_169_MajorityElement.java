package leetcode.array;


/**
 * @author baikal on 2019-02-28
 * @project Algorithm
 * Boyer-Moore Algorithm（多数投票算法）：记录一个当前过半数变量 A 及其个数 numA ，在遍历过程中，如果当前元素和记录元素 A 相等，
 * 则 numA 加 1；如果不相等，则 numA 减 1。如果 numA 为零，则更新 A 和重置 numA 。本质是：在遍历数组时，如果numA为0，
 * 表示当前并没有候选元素，也就是说之前的遍历过程中并没有找到超过半数的元素。那么，如果超过半数的元素A存在，那么A在剩下的子数组中，
 * 出现次数也一定超过半数。
 *
 */
public class _169_MajorityElement {
    public static int majorityElement(int[] nums) {
        if (nums == null) {
            throw new Error("error");
        }

        int count = 0;
        int target = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
                count = 1;
            } else if (target != nums[i]) {
                count--;
            } else {
                count++;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 2, 2};

        System.out.println(majorityElement(nums));
    }
}
