import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int [] nums = new int[n];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; ++ i) {
            nums[i] = i + 1;
        }
        backTrack(list, new ArrayList<>(), nums, 0, k);

        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index, int k) {
        if (k == 0) {
            list.add(new ArrayList<>(temp));
        }

        for (int i = index; i < nums.length; ++ i) {
            temp.add(nums[i]);
            backTrack(list, temp, nums, i + 1, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

