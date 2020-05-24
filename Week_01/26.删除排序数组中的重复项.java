/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 1;
        for (int i = 1; i < nums.length; ++ i) {
            if (nums[i] != nums[i - 1]) {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}
// @lc code=end

