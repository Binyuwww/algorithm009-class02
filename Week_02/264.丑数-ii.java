/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int [] dp = new int[n];

        dp[0] = 1;
        for (int i = 1; i < n; ++ i) {
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);

            if (dp[i] == dp[a] * 2) {
                a++;
            }

            if (dp[i] == dp[b] * 3) {
                b++;
            }

            if (dp[i] == dp[c] * 5) {
                c++;
            }
        }

        return dp[n - 1];
    }
}
// @lc code=end

