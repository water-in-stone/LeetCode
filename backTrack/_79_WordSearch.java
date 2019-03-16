package leetcode.backTrack;

/**
 * @author baikal on 2019-03-16
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
                if (backTrack(board, i, j, words, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean backTrack(char[][] board, int i, int j, char[] word, int length) {
        if (length == word.length) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word[length] || visited[i][j]) {
            return false;
        }

        // 标记已经访问过此节点
        visited[i][j] = true;

        if (backTrack(board, i - 1, j, word, length + 1) ||
                backTrack(board, i + 1, j, word, length + 1) ||
                backTrack(board, i, j - 1, word, length + 1) ||
                backTrack(board, i, j + 1, word, length + 1)
        ) {
            return true;
        }
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
