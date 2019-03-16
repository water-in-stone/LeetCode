package leetcode.bitOperation;

/**
 * @author baikal on 2019-03-16
 * @project Algorithm
 */
public class _461_HammingDistance {
    public static int hammingDistance(int x, int y) {
        int xy = x ^ y;
        int count = 0;
        while (xy > 0) {
            if ((xy & 1) == 1) {
                count++;
            }
            xy = xy >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;

        System.out.println(hammingDistance(x, y));
    }
}
