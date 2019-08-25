package leetcode.backTrack;

/**
 * @author baikal on 2019-03-16
 * 使用dfs进行回溯，所以需要一个visited数组来标记节点是否被访问过
 * 并进行状态重置
 * @project Algorithm
 */
public class _79_WordSearch {
    static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, char[] word, int length) {
        if (length == word.length) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word[length] || visited[i][j]) {
            return false;
        }

        // 标记已经访问过此节点
        visited[i][j] = true;

        if (dfs(board, i - 1, j, word, length + 1) ||
                dfs(board, i + 1, j, word, length + 1) ||
                dfs(board, i, j - 1, word, length + 1) ||
                dfs(board, i, j + 1, word, length + 1)
        ) {
            return true;
        }
        // 上下左右遍历后需要把当前节点的状态给还原
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {
//                        'A', 'B', 'C', 'E'
//                },
//                {
//                        'S', 'F', 'C', 'S'
//                },
//                {
//                        'A', 'D', 'E', 'E'
//                }
//        };
        char[][] board = {
                {
                        'A', 'B'
                },
                {
                        'C', 'D'
                },
        };
        String word = "CDBA";
        System.out.println(exist(board, word));

    }
}
