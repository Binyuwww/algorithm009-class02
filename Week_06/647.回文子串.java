import sun.net.www.HeaderParser;

/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); ++ i) {
            ans += helper(s, i, i);
            ans += helper(s, i, i + 1);
        }

        return ans;
    }

    private int helper(String s, int l, int r) {
        int cnt = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            cnt++;
        }
        return cnt;
    }
}
// @lc code=end

