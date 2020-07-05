import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        backTrack(list, "", 0, 0, n);
        return list;
    }

    private void backTrack(List<String> list, String temp, int l, int r, int max) {
        if (temp.length() == max * 2) {
            list.add(temp);
            return;
        }
        if (l < max) {
            backTrack(list, temp + "(", l + 1, r, max);
        }
        if (r < l) {
            backTrack(list, temp + ")", l, r + 1, max);
        }
    }
}
// @lc code=end

