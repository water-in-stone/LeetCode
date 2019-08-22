package leetcode.recursion;

import java.util.*;

/**
 * @author baikal on 2019-07-21
 * @project Algorithm 使用递归遍历的方法
 */
public class _200_NumIslands {
  static int count = 0;
  // 分别代表上、右、下、左的节点
  static int[][] directions = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
  static int rows;
  static int columns;
  // 标记访问过的节点
  static boolean[][] mark;

  public static int numIslands(char[][] grid) {
    if (grid == null) {
      return 0;
    } else if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    rows = grid.length;
    columns = grid[0].length;
    mark = new boolean[rows][columns];
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        // 若没有被访问过且为陆地，则进行dfs遍历
        if (!mark[i][j] && grid[i][j] == '1') {
          count++;
          dfs(i, j, grid);
        }
      }
    }

    return count;
  }

  // dfs遍历陆地
  public static void dfs(int i, int j, char[][] grid) {
    // 表示当前节点已经被访问过
    mark[i][j] = true;
    for (int k = 0; k < 4; k++) {
      int newX = i + directions[k][0];
      int newY = j + directions[k][1];
      // 若没有越界且是陆地,且没有被访问，则深度遍历
      if (inArea(newX, newY) && grid[newX][newY] == '1' && !mark[newX][newY]) {
        dfs(newX, newY, grid);
      }
    }
  }

  public static boolean inArea(int i, int j) {
    return i >= 0 && j >= 0 && i < rows && j < columns;
  }

  public static void main(String[] args) {
    char[][] grid1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' } };
    int numIslands1 = numIslands(grid1);
    System.out.println(numIslands1);
  }
}
