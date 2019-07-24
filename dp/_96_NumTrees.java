package leetcode.dp;

/**
 * @author baikal on 2019-07-23
 * @project Algorithm
 * 详见：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
 * G[2] = G[1]*G[0] + G[0]*G[1]
 * G[3] = G[1]*G[2] + G[1]*G[1] + G[2] * G[1]
 * ...
 * G[n] = （累加) G[i - 1] * G[n - i]
 */
public class _96_NumTrees {
    public static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }
}
