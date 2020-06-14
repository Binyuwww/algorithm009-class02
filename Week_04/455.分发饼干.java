import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);

        int si = 0;
        int gi = 0;
        while (si < s.length && gi < g.length) {
            if (s[si] >= g[gi]){
                gi++;
            }
            si ++;
        }
        return gi;
    }
}
// @lc code=end

