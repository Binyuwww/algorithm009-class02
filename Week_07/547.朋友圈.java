/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[M.length];
        int cnt = 0;

        for (int i = 0; i < M.length; ++ i) {
            if (!visited[i]) {
                dfs(M, visited, i);
                cnt ++;
            }
        }

        return cnt;
    }

    private void dfs (int[][] M, boolean[] visited, int i) {

        visited[i] = true;
        for (int j = 0; j < M.length; ++ j) {
            if (!visited[j] && M[i][j] == 1) {
                dfs(M, visited, j);
            }
        }
    }

}
// @lc code=end

