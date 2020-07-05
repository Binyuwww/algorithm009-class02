/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < col; ++ i) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if(board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }

        for (int j = 0; j < row; ++ j) {
            if (board[j][0] == 'O') {
                dfs(board, j, 0);
            }

            if (board[j][col - 1] == 'O') {
                dfs(board, j, col - 1);
            }
        }

        for (int i = 0; i < row; ++ i) {
            for (int j = 0; j < col; ++ j) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void dfs (char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }

        if (board[i][j] == '*') {
            return;
        }

        if (board[i][j] == 'O') {
            board[i][j] = '*';
            dfs(board, i + 1, j);
            dfs(board, i, j + 1);
            dfs(board, i - 1, j);
            dfs(board, i, j - 1);
        }
    }
}
// @lc code=end

