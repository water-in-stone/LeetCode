package leetcode.array;

public class _240_Search2DArray {
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length <= 0) {
      return false;
    }
    // 找到最右上角的元素，并开始搜索
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
      int val = matrix[row][col];
      if (val < target) {
        // 若当前值比目标值小，则向下走一步
        row++;
      } else if (val > target) {
        col--;
      } else {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] nums = { 
        { 1, 4, 7, 11, 15 }, 
        { 2, 5, 8, 12, 19 },
        { 3, 6, 9, 16, 22 }, 
        { 10, 13, 14, 17, 24 },
        { 18, 21, 23, 26, 30 } 
      };
    boolean isExisted = searchMatrix(nums, 9);
  }
}