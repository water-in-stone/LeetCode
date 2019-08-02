package leetcode.array;

/**
 * @author baikal on 2019-02-26
 * @project Algorithm
 *
 *          Tip: 双指针法的变种 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
 *          在每一步中，找出指针所指向的两条线段形成的区域，更新 maxArea，并将指向较短线段的指针向较长线段那端移动一步。
 * 
 *          贪心算法：从两边逼近最优解 正确性证明:
 *          假设x，y为最优解，i向右逐渐靠近x，j向左逐渐靠近y，那么i没有可能跳过x，j也没有可能跳过y；
 *          1、当j==y,i<x时,那么此时必定有height[i]<height[j],如果不是这样,i值就比x值更优,与假设矛盾,即必定是i向右移动直到i==x；
 *          2、当x==x,j>y时,同理；
 *
 *          时间复杂度O(n)，空间复杂度O(1)
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
        int[] example = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(example));
    }
}
