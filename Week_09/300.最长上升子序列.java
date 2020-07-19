import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;

        }

        int ans = 0;
        for (int num : nums) {
            int l = 0;
            int r = ans;

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < num) {
                    l = mid + 1;

                }else {
                    r = mid;
                }
            }

            nums[l] = num;
            if (ans == r) {
                ans ++;
            }
        }
        return ans;
    }
}
// @lc code=end

