/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int [][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] mark = new boolean[row][col];
        int cnt = 0;

        for (int i = 0; i < row; ++ i) {
            for (int j = 0; j < col; ++ j) {
                if (! mark[i][j] && grid[i][j] == '1') {
                    cnt++;
                    LinkedList<Integer> queue = new LinkedList<>();

                    queue.addLast(i * col + j);
                    mark[i][j] = true;

                    while(!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur/col;
                        int curY = cur%col;

                        for (int k = 0; k < 4; ++k ) {
                            int newX = curX + dir[k][0];
                            int newY = curY + dir[k][1];

                            if (newX >= 0 && newX < grid.length && newY >= 0 && 
                            newY < grid[0].length && grid[newX][newY] == '1' && 
                            !mark[newX][newY]) {
                                queue.addLast(newX * col + newY);
                                mark[newX][newY] = true;
                            }
                        }
                    }
                }

            }
        } 
        return cnt;

    }

}
// @lc code=end

