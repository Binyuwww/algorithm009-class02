/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, a.length - 1);

            while (i < j) {
                char tmep = a[i];
                a[i++] = a[j];
                a[j--] = tmep;
            }
        }

        return new String(a);
    }
}
// @lc code=end

