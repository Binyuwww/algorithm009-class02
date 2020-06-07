import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        backTrack(list, new ArrayList<>(), set, nums);
        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> temp, Set<Integer> set, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; ++ i) {
            if (set.contains(i)) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) {
                continue;
            }


            temp.add(nums[i]);
            set.add(i);
            backTrack(list, temp, set, nums);
            temp.remove(temp.size() - 1);
            set.remove(i);
        }
    }
}
// @lc code=end

