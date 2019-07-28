package leetcode.sort;

import java.util.*;

/**
 * @author baikal on 2019-07-25
 * @project Algorithm
 */
public class MergeSort {
  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0 || arr.length == 1) {
      return;
    }
    // 归并排序中，判断条件统一用<= ，所以是arr.length - 1
    int n = arr.length - 1;
    // 额外的空间来存储每一次排序的值
    int[] temp = new int[arr.length];
    sort(arr, 0, n, temp);
  }

  public static void sort(int[] arr, int left, int right, int[] temp) {
    // 避免left == right 时的无限递归，和mid + 1带来的越界
    if (left < right) {
      // 取出中间的index
      int mid = (left + right) / 2;
      // 进行左右排序
      sort(arr, left, mid, temp);
      sort(arr, mid + 1, right, temp);
      // 合并数组
      merge(arr, left, right, temp);
    }
  }

  public static void merge(int[] arr, int start, int end, int[] temp) {
    int t = 0;
    int left = start;
    int mid = (left + end) / 2;
    int right = mid + 1;

    // 开始合并2个有序数组
    while (left <= mid && right <= end) {
      if (arr[left] <= arr[right]) {
        temp[t++] = arr[left++];
      } else {
        temp[t++] = arr[right++];
      }
    }
    // 左数组还有元素富余
    while (left <= mid) {
      temp[t++] = arr[left++];
    }
    // 右数组还有元素富余
    while (right <= end) {
      temp[t++] = arr[right++];
    }

    // 将合并后的结果给复制到原先的数组上
    // 因为每一步都是在原有的arr数组上进行操作，所以是从原先的arr数组的left下标开始进行赋值
    t = 0;
    while (start <= end) {
      arr[start++] = temp[t++];
    }
  }

  public static void main(String[] args) {
    int[] test = { 1, 5, 2, 7, 8, 2, 4, 6, 2, 1, 14, 10 };
    sort(test);
    System.out.println(Arrays.toString(test));
  }
}
