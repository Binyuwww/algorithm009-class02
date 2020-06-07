import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        backTrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> temp, int [] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; ++ i) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backTrack(list, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

