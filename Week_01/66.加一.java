/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        
        int i = digits.length - 1;

        while (i >= 0) {
            if (i < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
            i --;
        }

        int [] ans = new int [digits.length + 1];
        ans[0] = 1;
        return ans;

    }
}
// @lc code=end

