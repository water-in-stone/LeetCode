package leetcode.other;

/**
 * @author baikal on 2019年09月02日21:29:08
 * @project Algorithm
 */
public class _09_isPalindrome {
  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int div = 1;
    // 找出x的最高位，对1221来说是1000
    while (x / div >= 10) {
      div = div * 10;
    }

    while (x > 0) {
      int left = x / div;
      int right = x % 10;
      if (left != right)
        return false;
      // 最左边和最右边的数判断完成后，令1221变为21
      x = (x % div) / 10;
      div = div / 100;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(3));
  }
}
