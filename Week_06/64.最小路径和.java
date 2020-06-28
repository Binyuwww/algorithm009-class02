/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int x = grid.length;
        int y = grid[0].length;

        for (int i = 0; i < x; ++ i) {
            for (int j = 0; j < y; ++ j) {
                if (i == 0 && j == 0) {
                    continue;
                }else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[x - 1][y - 1];
    }
}
// @lc code=end

