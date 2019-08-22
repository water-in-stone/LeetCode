package leetcode.list;

import java.util.*;

public class _374_TopKFrequent {
  public static List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new LinkedList<>();
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
    }
    // 令其作为一个最大堆，堆顶是出现次数最多的元素
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
      // 递增排列
      return count.get(a) - count.get(b);
    });
    for (Integer a : count.keySet()) {
      if (heap.size() < k) {
        heap.add(a);
      } else if (count.get(a) > count.get(heap.peek())) {
        // 若堆顶元素出现次数小于当前元us，则去除队头的元素
        heap.poll();
        heap.add(a);
      }
    }
    while (heap.size() > 0) {
      int num = heap.poll();
      res.add(num);
    }
    // 反转数组
    Collections.reverse(res);
    return res;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 2, 2, 3 };
    List<Integer> res = topKFrequent(nums, 2);
    System.out.println(res);
  }
}