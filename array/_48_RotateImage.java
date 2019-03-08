package leetcode.array;

/**
 * @author baikal on 2019-03-07
 * @project Algorithm
 * 思路：
 * 1. 先斜对角做变换
 * [1  2  3       [1  4  7
 * 4  5  6  变为   2  5  8
 * 7  8  9]       3   6  9]
 * <p>
 * 2. 再做左右镜像
 * [1  4  7       [7  4  1
 * 2  5  8   变为  8  5  2
 * 3  6  9]       9  6  3]
 */
public class _48_RotateImage {
    public static void rotate(int[][] matrix) {
        // 按照斜对角的对称轴进行翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 左右进镜像
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp  = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j -1];
                matrix[i][matrix[i].length - j -1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(matrix);
    }
}
