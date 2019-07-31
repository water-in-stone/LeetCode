package leetcode.other;

/**
 * @author baikal on 2019-02-12
 * @project Algorithm 
 * 边界条件，当left > right时，退出循环
 */
public class BinarySearch {
  public static int search(int[] array, int key) {
    if (array == null || array.length == 0) {
      return -1;
    }
    if (array.length == 1) {
      return array[0] == key ? 0 : -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] == key) {
        return mid;
      } else if (array[mid] < key) {
        // 令左边界+1
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] array = { 1, 2, 4, 5, 6, 8, 9 };
    System.out.println(search(array, 11));
  }
}
