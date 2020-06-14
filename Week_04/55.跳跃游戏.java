/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int right = 0;
        for (int i = 0; i < nums.length; ++ i) {
            if (i > right) {
                return false;
            }
            right = Math.max(right, i + nums[i]);
        }

        return true;
    }
}
// @lc code=end

