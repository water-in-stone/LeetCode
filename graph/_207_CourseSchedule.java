package leetcode.graph;

import java.util.*;

/**
 * @author baikal on 2019-02-24
 * 
 */
public class _207_CourseSchedule {
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0) {
      return false;
    }
    int plen = prerequisites.length;
    if (plen == 0) {
      return true;
    }
    int[] inDegree = new int[numCourses];
    // 统计入度
    for (int[] p : prerequisites) {
      inDegree[p[0]]++;
    }
    LinkedList<Integer> queue = new LinkedList<>();
    // 首先加入入度为 0 的结点
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.addLast(i);
      }
    }
    // 拓扑排序的结果
    List<Integer> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int num = queue.removeFirst();
      res.add(num);
      // 把邻边全部遍历一下
      for (int[] p : prerequisites) {
        if (p[1] == num) {
          inDegree[p[0]]--;
          if (inDegree[p[0]] == 0) {
            queue.addLast(p[0]);
          }
        }
      }
    }
    // System.out.println("拓扑排序结果：");
    // System.out.println(res);
    return res.size() == numCourses;
  }

  public static void main(String[] args) {
    int[][] a = { { 1, 0 }, { 0, 1 } };
    boolean res = canFinish(2, a);

    System.out.println(res);
  }
}
