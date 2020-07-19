/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    private int left = 0;
    private int res = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        for (int i = 0; i < s.length(); ++ i) {
            helper(s, i, i);
            helper(s, i, i + 1);
        } 

        return s.substring(left, res + left);
    }

    private void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (res < r - l + 1) {
                left = l;
                res = r - l + 1;
            }
            l--;
            r++;
        }
    }


}
// @lc code=end

