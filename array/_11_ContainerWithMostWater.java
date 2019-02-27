package leetcode.array;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 *
 * Tip: 双指针法的变种
 * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
 * 在每一步中，找出指针所指向的两条线段形成的区域，更新 maxArea，并将指向较短线段的指针向较长线段那端移动一步。
 *
 * 时间复杂度O(n)，空间复杂度O(1)
 */
public class _11_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] example = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(example));
    }
}
