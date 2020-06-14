/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {

    int [] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int [] dy = {1, 1, 1, 0, -1, -1, -1, 0}; 

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs (board, click[0], click[1]);
        return board;
    }

    private void dfs (char [][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;

        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        
        if (board[x][y] == 'E') {
            board[x][y] = 'B';

            int cnt = helper(board, x, y);
            if (cnt == 0) {
                for (int i = 0; i < 8; ++ i) {
                    dfs (board, x + dx [i], y + dy [i]);
                }
            }else {
                board[x][y] = (char)(cnt + '0');
            }
        }else if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }

    private int helper (char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;

        int cnt = 0;

        for (int i = 0; i < 8; ++ i) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }

            if (board[newX][newY] == 'M') {
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end

