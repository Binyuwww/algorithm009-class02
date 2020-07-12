import java.awt.List;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        if (len < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 0; i < len; ++ i) {
            int[] curr = intervals[i];
            int[] peek = list.get(list.size() - 1);

            if (curr[0] > peek[1]) {
                list.add(curr);
            }else{
                peek[1] = Math.max(peek[1], curr[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

