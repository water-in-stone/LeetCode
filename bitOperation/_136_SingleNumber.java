package leetcode.bitOperation;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 * 经典题，用异或来判断两数，相同为0，不同为1. 异或同一个数两次，原数不变。
 */
public class _136_SingleNumber {
    public static int singleNumber(int[] nums) {
        if (nums == null) {
            throw new Error("error");
        }

        int single = 0;

        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }

        return single;
    }

    public static void main(String[] args) {
        int[] example = {2, 2, 1};

        System.out.println(singleNumber(example));
    }
}
