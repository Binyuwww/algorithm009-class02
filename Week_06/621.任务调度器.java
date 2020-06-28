/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        int [] dict = new int[26];
        for (int i = 0; i < tasks.length; ++ i) {
            dict[tasks[i] - 'A'] ++;
        }

        Arrays.sort(dict);
        int max = dict[25];
        int cnt = (max - 1) * (n + 1) + 1;
        int index = 24;

        while (index >= 0 && dict[index] == max) {
            cnt ++;
            index--;
        }

        return Math.max(cnt, tasks.length);
    }
}
// @lc code=end

