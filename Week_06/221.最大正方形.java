/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int side = 0;
        int [][] dp = new int [row + 1][col + 1];

        for (int i = 0; i < row; ++ i) {
            for (int j = 0; j < col; ++ j) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
                side = Math.max(side, dp[i + 1][j + 1]);
            }
        }

        return side * side;
    }
}
// @lc code=end

