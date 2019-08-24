package leetcode.other;

/**
 * @author baikal on 2019-02-12
 * @project Algorithm 边界条件，当left > right时，退出循环
 */
public class _338_CountingBits {
  public static int[] countBits(int num) {
    int[] res = new int[num + 1];
    // 初始化
    res[0] = 0;
    for (int i = 1; i <= num; i++) {
      if (i % 2 == 0) {
        // 若为偶数，则1的个数与➗以2之后的数相同，例如2和4、3和6
        res[i] = res[i / 2];
      } else {
        // 若为奇数，则1的个数是是比它小且离最近的偶数 + 1
        res[i] = res[i - 1] + 1;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(countBits(11));
  }
}
