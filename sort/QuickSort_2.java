package leetcode.sort;

import java.util.*;

/**
 * @author baikal on 2019-07-25
 * @project Algorithm
 * 
 */
public class QuickSort_2 {
  public static void quickSort(int[] arr) {
    help(arr, 0, arr.length - 1);
  }

  public static void help(int[] arr, int low, int high) {
    if (low < high) {
      int partition = partition(arr, low, high);
      help(arr, low, partition);
      help(arr, partition + 1, high);
    }
  }

  public static int partition(int[] arr, int low, int high) {
    int i = low;
    int pivot = arr[low];
    while (low < high) {
      // 从右侧找比Pivot小的值
      while (pivot <= arr[high] && low < high) {
        high--;
      }
      while (arr[low] <= pivot && low < high) {
        low++;
      }
      if (low < high) {
        swap(arr, low, high);
      }
    }
    // 最后交换一开始的pivot的值到哨兵相逢处
    swap(arr, i, high);
    return low;
  }

  public static void swap(int[] arr, int low, int high) {
    int temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 4, 5, 2, 6, 3, 2, 8, 9 };
    quickSort(arr);
    for (int s : arr) {
      System.out.println(s);
    }
  }
}
