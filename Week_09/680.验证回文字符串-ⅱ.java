import javax.swing.text.html.HeadAction;

/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j; ++ i, -- j) {
            if (s.charAt(i) != s.charAt(j)) {
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean helper (String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

