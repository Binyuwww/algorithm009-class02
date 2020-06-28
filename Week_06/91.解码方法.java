/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 

        int len = s.length();
        int [] dp = new int [len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; -- i) {
            if (s.charAt(i) == '0') {
                continue;
            }

            int a1 = dp[i + 1];
            int a2 = 0;

            int one = s.charAtdrf(i + 1) - '0';
            int ten = (s.charAt(i) - '0') * 10;
            if (one + ten <= 26) {
                a2 = dp[i + 2];
            }
            
            dp[i] = a1 + a2;
        }

        return dp[0];
    }
}
// @lc code=end

