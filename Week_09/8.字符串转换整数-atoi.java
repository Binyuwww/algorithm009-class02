/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }            
        
        int index = 0;
        int len = str.length();
        while (str.charAt(index) == ' ') {
            index ++;
        }

        if (index == len) {
            return 0;
        }

        int sig = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (str.charAt(index) == '-') {
                sig = - 1;

            }
            index ++;
        }
        if (index == len) {
            return 0;
        }

        int ans = 0;
        while (index < len) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }

            int nums = str.charAt(index) - '0';
            int temp = ans * 10 + nums;
            if (temp / 10 != ans) {
                return 0;
            }
            ans = temp;
            index ++;

        }
        return sig * ans;

 
    }
}
// @lc code=end

