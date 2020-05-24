import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
// @lc code=end

