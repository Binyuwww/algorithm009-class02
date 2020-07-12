import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] wordSet = new int[26];
        for (int i = 0; i < s.length(); ++ i) {
            wordSet[s.charAt(i) - 'a'] ++;
            wordSet[t.charAt(i) - 'a'] --;
        }

        for(int num : wordSet) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

