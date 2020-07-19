import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }

        for (int i = 0; i < s.length(); ++ i) {
            if (dict[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

